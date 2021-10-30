import android.content.ContentValues.TAG
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapp2.databinding.ActivityMainBinding
import com.google.firebase.dynamiclinks.ShortDynamicLink
import com.google.firebase.dynamiclinks.ktx.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setRetrofit()

    }


    private fun setRetrofit(){

        val retrofit = Retrofit.Builder()
            .baseUrl("http://xx.x.x.x:포트번호/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val call:Call<List<ResponseDTO>> = service.getRequest()

        call.enqueue(object : Callback<List<ResponseDTO>>{

            override fun onFailure(call: Call<List<ResponseDTO>>?, t: Throwable?) {
                t!!.printStackTrace();  // https://okky.kr/article/545778?note=1614261
                Toast.makeText(applicationContext,"fail",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<ResponseDTO>>, response: Response<List<ResponseDTO>>) {
                Toast.makeText(applicationContext,"success",Toast.LENGTH_SHORT).show()
                val allData = response.body()
                    if (allData!= null) {
                        println("All datas are loaded :")

                        for (c in allData) {
                           // println(" one data : ${c.placeName}")
                               text1.text = c.grade.toString()
                               text2.text = c.placeName
                        }


                    //text1.text = response.body()!!.emotion.toString()
                    //text2.text = response.body()!!.placeName
                    //text3.text = response.body()!!.grade.toString()
                }
            }

        })

    }


    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        return builder.build()
    }


}