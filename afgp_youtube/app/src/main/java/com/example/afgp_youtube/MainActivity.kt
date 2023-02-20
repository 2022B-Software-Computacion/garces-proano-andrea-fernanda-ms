package com.example.afgp_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val videos = listOf(
        Video("https://i.ytimg.com/vi/FWTNMzK9vG4/mqdefault.jpg", "Why you procrastinate even when it feels bad"),
        Video("https://i.ytimg.com/vi/hqR-vmO-7HM/mqdefault.jpg", "¿Por qué se produce un eclipse?"),
        Video("https://i.ytimg.com/vi/iE9ctGo6N88/mqdefault.jpg", "『CASTLE』 - Heaven"),
        Video("https://i.ytimg.com/vi/dQw4w9WgXcQ/maxresdefault.jpg", "Rick Astley - Never Gonna Give You Up (Video)")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.video_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VideoAdapter(videos)
    }

}