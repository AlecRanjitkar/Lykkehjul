package com.example.lykkehjul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton: Button = findViewById(R.id.Knap)

        playButton.setOnClickListener {
            val intent = Intent(this, Spilgame::class.java)
            startActivity(intent)
        }

    }
}