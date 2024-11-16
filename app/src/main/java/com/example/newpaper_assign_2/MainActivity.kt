package com.example.newpaper_assign_2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.navy));


        val listView = findViewById(R.id.listview) as ListView
        val title = resources.getStringArray(R.array.title)
        val body = resources.getStringArray(R.array.body)
        val img = resources.obtainTypedArray(R.array.img)

        // Convert the obtained TypedArray to an Array<Int>
        val imgArray = Array(img.length()) { img.getResourceId(it, 0) }
        img.recycle() // Recycle the TypedArray

        val ListViewAdapter = ListViewAdapter(this,title,body,imgArray)
        listView.adapter = ListViewAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("title", title[position])
            intent.putExtra("body", body[position])
            intent.putExtra("img", imgArray[position])
            startActivity(intent)
        }
    }
}