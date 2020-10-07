package dk.iutube.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dk.iutube.R
import dk.iutube.activity.PlayerActivity
import dk.iutube.data.Video
import java.lang.NullPointerException

class VideoAdapter(val context: Context, val data: List<Video.Item>) : RecyclerView.Adapter<VideoAdapter.VideoVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoVH =
        VideoVH(LayoutInflater.from(context).inflate(R.layout.video_item, null))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VideoVH, position: Int) {
        holder.bind(data[position])
    }

    class VideoVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imgView: ImageView = view.findViewById(R.id.imv)
        private val titleView: TextView = view.findViewById(R.id.txt)


        fun bind(data: Video.Item){
            titleView.text = data.snippet.title

            try {
                Glide.with(imgView.context).load(data.snippet.thumbnails.default.url).into(imgView)
            }catch (e: NullPointerException){
                Log.d("err", "NULL")
            }

            itemView.setOnClickListener {
                it.context.startActivity(
                    Intent(it.context, PlayerActivity::class.java)
                        .apply {
                            putExtra("url", data.snippet.resourceId.videoId)
                        }
                )
            }
        }
    }
}