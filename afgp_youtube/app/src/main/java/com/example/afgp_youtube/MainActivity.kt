package com.example.afgp_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videos = listOf(
            Video("https://i.ytimg.com/vi/FWTNMzK9vG4/mqdefault.jpg",
                "  Why you procrastinate even when it feels bad",
                ContextCompat.getDrawable(this, R.drawable.teded)!!,
                "TED-Ed",
                "3,6 M de vistas "),
            Video("https://i.ytimg.com/vi/hqR-vmO-7HM/mqdefault.jpg",
                "  ¿Por qué se produce un eclipse?",
                ContextCompat.getDrawable(this, R.drawable.planetario)!!,
                "Planetario Chile",
                "621.541 visitas"),
            Video("https://i.ytimg.com/vi/iE9ctGo6N88/mqdefault.jpg",
                "『CASTLE』 - Heaven",
                ContextCompat.getDrawable(this, R.drawable.dios)!!,
                "Dios",
                "572.135 visitas"),
            Video("https://i.ytimg.com/vi/dQw4w9WgXcQ/maxresdefault.jpg",
                "  Never Gonna Give You Up (Video)",
                ContextCompat.getDrawable(this, R.drawable.rickastley)!!,
                "Rick Astley",
                "1357 M de visitas")
        )

        val recyclerView: RecyclerView = findViewById(R.id.video_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VideoAdapter(videos)
    }

}