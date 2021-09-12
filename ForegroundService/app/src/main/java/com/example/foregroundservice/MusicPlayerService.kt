package com.example.foregroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MusicPlayerService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "Action Received = ${intent?.action}")
        // intent가 시스템에 의해 재생성되었을때 null값이므로 Java에서는 null check 필수
        when (intent?.action) {
            "com.gold24park.musicplayerexample.action.startforeground" -> {
                Log.e(TAG, "Start Foreground 인텐트를 받음")
                startForegroundService()
            }
            "com.gold24park.musicplayerexample.action.stopforeground" -> {
                Log.e(TAG, "Stop Foreground 인텐트를 받음")
                stopForegroundService()
            }
            "com.gold24park.musicplayerexample.action.prev" -> Log.e(TAG, "Clicked = 이전")
            "com.gold24park.musicplayerexample.action.play" -> Log.e(TAG, "Clicked = 재생")
            "com.gold24park.musicplayerexample.action.next" -> Log.e(TAG, "Clicked = 다음")
        }
        return START_STICKY
    }

    private fun startForegroundService() {
        val notification = MusicNotification.createNotification(this)
        startForeground(NOTIFICATION_ID, notification)
    }

    private fun stopForegroundService() {
        stopForeground(true)
        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? {
        // bound service가 아니므로 null
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy()")
    }

    companion object {
        const val TAG = "[MusicPlayerService]"
        const val NOTIFICATION_ID = 20
    }

}