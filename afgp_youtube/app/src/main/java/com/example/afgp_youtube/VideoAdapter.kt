package com.example.afgp_youtube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class VideoAdapter(private val videos: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnailImageView: ImageView = itemView.findViewById(R.id.video_thumbnail)
        val titleTextView: TextView = itemView.findViewById(R.id.video_title)
        val channelImageView: ImageView = itemView.findViewById(R.id.video_channel_icon)
        val channelNameTextView: TextView = itemView.findViewById(R.id.video_channel_name)
        val viewsTextView: TextView = itemView.findViewById(R.id.video_views_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videos[position]
        holder.titleTextView.text = video.title
        Glide.with(holder.itemView.context)
            .load(video.thumbnailUrl)
            .into(holder.thumbnailImageView)
        holder.channelImageView.setImageDrawable(video.channelImg)
        holder.channelNameTextView.text = video.channelName
        holder.viewsTextView.text = video.views
    }

    override fun getItemCount() = videos.size


}
