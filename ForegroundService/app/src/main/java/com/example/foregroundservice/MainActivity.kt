package com.example.foregroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val intent = Intent(this@MainActivity, MusicPlayerService::class.java)
            intent.action = "com.gold24park.musicplayerexample.action.startforeground"
            startService(intent)
        }

        btn_stop.setOnClickListener {
            val intent = Intent(this@MainActivity, MusicPlayerService::class.java)
            intent.action = "com.gold24park.musicplayerexample.action.stopforeground"
            startService(intent)
        }
    }

}
