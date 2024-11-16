package com.example.newpaper_assign_2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.navy));



        val title = intent.getStringExtra("title")
        val body = intent.getStringExtra("body")
        val imgResId = intent.getIntExtra("img", 0)

        val titleTextView = findViewById<TextView>(R.id.title)
        val bodyTextView = findViewById<TextView>(R.id.body)
        val imageView = findViewById<ImageView>(R.id.img)

        titleTextView.text = title
        bodyTextView.text = body
        imageView.setImageResource(imgResId)
    }
}