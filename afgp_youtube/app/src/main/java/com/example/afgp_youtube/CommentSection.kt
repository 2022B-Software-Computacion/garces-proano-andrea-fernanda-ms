package com.example.afgp_youtube

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CommentSection : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_section)

        val comments = listOf(
            Comment(
                ContextCompat.getDrawable(this, R.drawable.teded)!!,
                "    Cordell Moreland",
                "MESSAGE TO FUTURE: DON'T LET THIS MASTERPIECE DIE"
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.planetario)!!,
                "    Nukeking Ratty gang",
                "This song will never get old"
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.dios)!!,
                "    Antonis_moonwalker",
                "Immortal song. No matter how many years passed, it will never be forgotten."
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.rickastley)!!,
                "    Anthem",
                "It's not just a song, it's a feeling."
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.teded)!!,
                "    agustin alcala",
                "I will never get tired of listening to this song, it fascinates me, I listen to it over and over again"
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.dios)!!,
                "    Kelly Hodosi",
                "Este tema musical será para toda la eternidad"
            ),Comment(
                ContextCompat.getDrawable(this, R.drawable.rickastley)!!,
                "    Legendary Het",
                "Probably one of the most popular songs ever on YouTube which never gets old"
            ),
        )

        val recyclerView: RecyclerView = findViewById(R.id.comment_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CommentAdapter(comments)
    }
}