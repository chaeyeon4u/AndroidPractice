package com.example.foregroundservice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.*
import android.os.Build
import androidx.core.app.NotificationCompat

object MusicNotification {
    const val CHANNEL_ID = "foreground_service_channel" // 임의의 채널 ID

    fun createNotification(
        context: Context
    ): Notification {
        // 알림 클릭시 MainActivity로 이동됨
        val notificationIntent = Intent(context, MainActivity::class.java)
        notificationIntent.action = Actions.MAIN
        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent
            .getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        // 각 버튼들에 관한 Intent
        val prevIntent = Intent(context, MusicPlayerService::class.java)
        prevIntent.action = Actions.PREV
        val prevPendingIntent = PendingIntent
            .getService(context, 0, prevIntent, 0)

        val playIntent = Intent(context, MusicPlayerService::class.java)
        playIntent.action = Actions.PLAY
        val playPendingIntent = PendingIntent
            .getService(context, 0, playIntent, 0)

        val nextIntent = Intent(context, MusicPlayerService::class.java)
        nextIntent.action = Actions.NEXT
        val nextPendingIntent = PendingIntent
            .getService(context, 0, nextIntent, 0)

        // 알림
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Music Player")
            .setContentText("My Music")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true) // true 일경우 알림 리스트에서 클릭하거나 좌우로 드래그해도 사라지지 않음
            .addAction(NotificationCompat.Action(android.R.drawable.ic_media_previous,
                "Prev", prevPendingIntent))
            .addAction(NotificationCompat.Action(android.R.drawable.ic_media_play,
                "Play", playPendingIntent))
            .addAction(NotificationCompat.Action(android.R.drawable.ic_media_next,
                "Next", nextPendingIntent))
            .setContentIntent(pendingIntent)
            .build()


        // Oreo 부터는 Notification Channel을 만들어야 함
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Music Player Channel", // 채널표시명
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }

        return notification
    }
}