package com.example.tutorial1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat


class MusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private val binder: IBinder = MusicBinder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    fun startMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        mediaPlayer!!.start()
        createNotification()
    }

    override fun onDestroy() {
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
        super.onDestroy()
    }

    private fun createNotification() {
        // Create a notification channel (if targeting API level 26 or higher)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the channel
            val channel = NotificationChannel(
                "channel_id",
                "Channel Name",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            // Configure the channel
            channel.description = "Channel Description"

            // Register the channel with the system
            val notificationManager: NotificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Create the notification
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "channel_id")
            .setContentTitle("Music Player")
            .setContentText("Playing Music")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        // Start the service as a foreground service
        startForeground(1, builder.build())
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    inner class MusicBinder: Binder() {
        fun getService() = this@MusicService

    }
}