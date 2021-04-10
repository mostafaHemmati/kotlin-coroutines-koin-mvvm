package com.hemmati.coroutineskoinsampleproject.presentation.videos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hemmati.coroutineskoinsampleproject.R
import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Mostviewedvideo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_list_item.view.*
import kotlin.properties.Delegates

class VideosAdapter :
    RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    var onItemClick: ((Mostviewedvideo) -> Unit)? = null
    var videos: List<Mostviewedvideo> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])

    }

    override fun getItemCount(): Int = if (videos.isNullOrEmpty()) 0 else videos.size


    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(videos[adapterPosition])
            }
        }

        fun bind(mostviewedvideo: Mostviewedvideo) {

            itemView.titleTextView.text = mostviewedvideo.title

            Picasso.get().load(mostviewedvideo.small_poster).fit()
                .error(R.drawable.ic_baseline_terrain_24).into(itemView.posterImageView)

        }

    }

}