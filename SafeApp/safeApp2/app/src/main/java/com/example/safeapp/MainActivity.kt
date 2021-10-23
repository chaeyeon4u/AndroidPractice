package com.jjs.safeapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.Image
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.common.util.concurrent.ListenableFuture
import com.jjs.safeapp.ml.Safe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.tensorflow.lite.support.model.Model
import org.tensorflow.lite.support.label.Category
import org.tensorflow.lite.support.image.TensorImage
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

typealias CameraBitmapOutputListner = (bitmap: Bitmap) -> Unit

class MainActivity : AppCompatActivity() {

    private var preview: Preview? = null
    private var imageAnalyzer: ImageAnalysis? = null
    private var cameraProvider: ProcessCameraProvider? = null
    private var lensFacing: Int = CameraSelector.LENS_FACING_FRONT
    private var camera: Camera? = null
    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupML()
        setupCameraThread()
        setupCameraControllers()

        if(!allPermissionsGranted){
            requireCameraPermission()
        }
        else{
            setupCamera()
        }
    }

    private fun requireCameraPermission() {
        ActivityCompat.requestPermissions(
            this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
        )
    }

    private fun setupCameraControllers() {
        fun setLensButtonIcon(){
            btn_camera_lens_face.setImageDrawable(
                AppCompatResources.getDrawable(
                    applicationContext,
                    if(lensFacing == CameraSelector.LENS_FACING_FRONT)
                        R.drawable.ic_baseline_camera_rear_24
                else
                    R.drawable.ic_baseline_camera_front_24
                )
            )
        }

        setLensButtonIcon()
        btn_camera_lens_face.setOnClickListener{
            lensFacing = if(CameraSelector.LENS_FACING_FRONT==lensFacing){
                CameraSelector.LENS_FACING_BACK
            }
            else{
                CameraSelector.LENS_FACING_FRONT
            }
            setLensButtonIcon()
            setupCameraUseCases()
        }
        try{
            btn_camera_lens_face.isEnabled = hasBackCamera && hasFrontCamera
        }
        catch (exception: CameraInfoUnavailableException){
            btn_camera_lens_face.isEnabled = false
        }
    }

    private fun setupCameraUseCases() {
        val cameraSelector: CameraSelector =
            CameraSelector.Builder().requireLensFacing(lensFacing).build()

        val metrics: DisplayMetrics =
            DisplayMetrics().also {preview_view.display.getRealMetrics(it)}
        val rotation: Int = preview_view.display.rotation
        val screenAspectRatio: Int = aspectRatio(metrics.widthPixels, metrics.heightPixels)
        preview = Preview.Builder()
            .setTargetAspectRatio(screenAspectRatio)
            .setTargetRotation(rotation)
            .build()

        imageAnalyzer = ImageAnalysis.Builder()
            .setTargetAspectRatio(screenAspectRatio)
            .setTargetRotation(rotation)
            .build()
            .also { it.setAnalyzer(
                cameraExecutor, BitmapOutputAnalysis(applicationContext){
                    bitmap-> setupMLOutput(bitmap)
                })
            }
        cameraProvider?.unbindAll()
        try {
            camera = cameraProvider?.bindToLifecycle(
                this, cameraSelector, preview, imageAnalyzer
            )
            preview?.setSurfaceProvider(preview_view.createSurfaceProvider())
        }
        catch(exc: Exception){
            Log.e(TAG, "Use CASE BINDING FAILURE", exc)
        }
    }

    private lateinit var safe: Safe
    private fun setupML() {
        val options: Model.Options =
            Model.Options.Builder().setDevice(Model.Device.GPU).setNumThreads(5).build()
        safe = Safe.newInstance(applicationContext, options)
    }

    private fun setupMLOutput(bitmap: Bitmap) {
        val tensorImage: TensorImage = TensorImage.fromBitmap(bitmap)
        val result: Safe.Outputs = safe.process(tensorImage)
        val output: List<Category> =
            result.probabilityAsCategoryList.apply{
                sortByDescending{ res -> res.score }
            }
        lifecycleScope.launch(Dispatchers.Main){
            output.firstOrNull()?.let{
                    category ->
                if(category.label == "unsafety") tv_output.text = "불안전" else tv_output.text = "안전"
                tv_output.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        if(category.label == "unsafety") R.color.yellow else R.color.green
                    )
                )
                overlay.background = getDrawable(
                    if(category.label == "unsafety") R.drawable.yellow_border else R.drawable.green_border
                )
                pb_output.progressTintList = AppCompatResources.getColorStateList(
                    applicationContext,
                    if(category.label == "unsafety") R.color.yellow else R.color.green
                )
                pb_output.progress = (category.score * 100).toInt()

                pb_output_text.setText(String.format("%.2f%%", (category.score * 100)))
                pb_output_text.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        if(category.label == "unsafety") R.color.yellow else R.color.green
                    )
                )
            }
        }
    }

    private fun setupCameraThread() {
        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun grantedCameraPermission(requestCode: Int){
        if(requestCode == REQUEST_CODE_PERMISSIONS){
            if(allPermissionsGranted){
                setupCamera()
            }
            else{
                Toast.makeText(this, "Permission NOT granted by the user.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun setupCamera() {
        val cameraProviderFuture: ListenableFuture<ProcessCameraProvider> =
            ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener(Runnable {
            cameraProvider = cameraProviderFuture.get()

            lensFacing = when{
                hasFrontCamera -> CameraSelector.LENS_FACING_FRONT
                hasBackCamera -> CameraSelector.LENS_FACING_BACK
                else -> throw IllegalStateException("No cameras on this devices")
            }
            setupCameraControllers()
            setupCameraUseCases()
        }, ContextCompat.getMainExecutor(this))
    }

    private val allPermissionsGranted: Boolean
    get(){
        return  REQUIRED_PERMISSIONS.all{
            ContextCompat.checkSelfPermission(
                baseContext,it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private val hasBackCamera: Boolean
        get(){
            return cameraProvider?.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA) ?: false
        }
    private val hasFrontCamera: Boolean
        get(){
            return cameraProvider?.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA) ?: false
        }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        grantedCameraPermission(requestCode)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setupCameraControllers()
    }

    private fun aspectRatio(width: Int, height: Int): Int{
        val previewRatio: Double = max(width, height).toDouble() / min(width, height)
        if(abs(previewRatio - RATIO_4_3_VALUE)  <= abs(previewRatio - RATIO_16_9_VALUE))
        {
            return AspectRatio.RATIO_4_3
        }
        return AspectRatio.RATIO_16_9
    }


    companion object{
        private const val TAG = "Safe"
        private const val REQUEST_CODE_PERMISSIONS = 0x98
        private val REQUIRED_PERMISSIONS: Array<String> = arrayOf(Manifest.permission.CAMERA)
        private const val RATIO_4_3_VALUE: Double = 4.0 / 3.0
        private const val RATIO_16_9_VALUE: Double = 16.0 / 9.0
    }
}

private class BitmapOutputAnalysis(
    context: Context,
    private val listener: CameraBitmapOutputListner
):
        ImageAnalysis.Analyzer{
            private val yuvToRgbConverter = YuvToRgbConverter(context)
    private lateinit var bitmapBuffer: Bitmap
    private lateinit var rotationMatrix: Matrix

    @SuppressLint("UnsafeExperimentalUsageError", "UnsafeOptInUsageError")
    private fun ImageProxy.toBitmap(): Bitmap?{
        val image: Image = this.image?:return null
        if(! :: bitmapBuffer.isInitialized){
            rotationMatrix = Matrix()
            rotationMatrix.postRotate(this.imageInfo.rotationDegrees.toFloat())
            bitmapBuffer = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
        }

        yuvToRgbConverter.yuvToRgb(image, bitmapBuffer)

        return Bitmap.createBitmap(
            bitmapBuffer,
            0,
            0,
            bitmapBuffer.width,
            bitmapBuffer.height,
            rotationMatrix,
            false
        )
    }

    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.toBitmap()?.let{
            listener(it)
        }
        imageProxy.close()
    }
}