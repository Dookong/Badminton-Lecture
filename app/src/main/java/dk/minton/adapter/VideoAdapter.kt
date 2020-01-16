package dk.minton.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dk.minton.R
import dk.minton.data.Video

class VideoAdapter(val context: Context, val data: List<Video.Item>) : RecyclerView.Adapter<VideoAdapter.VideoVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH =
        VideoVH(LayoutInflater.from(context).inflate(R.layout.video_item, null))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VideoVH, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            it.context.startActivity(Intent())
        }
    }

    class VideoVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imgView: ImageView = view.findViewById(R.id.imv)
        private val titleView: TextView = view.findViewById(R.id.txt)
        private val descView: TextView = view.findViewById(R.id.desc)


        fun bind(data: Video.Item){
            titleView.text = data.snippet.title
            descView.text = data.snippet.description

            Glide.with(imgView.context)
                .load(data.snippet.thumbnails.default.url)
                .into(imgView)
        }
    }
}