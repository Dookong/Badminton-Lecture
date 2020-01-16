package dk.minton.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dk.minton.R
import dk.minton.adapter.VideoAdapter
import dk.minton.api.Key
import dk.minton.api.VideoServiceImpl
import dk.minton.data.Video
import kotlinx.android.synthetic.main.fragement_rv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment(private val playlistid: String) : Fragment() {
    val part = "snippet,status"
    val fieds = "nextPageToken,items(snippet(publishedAt,title,resourceId,thumbnails),status)"
    val maxresults = 30

    lateinit var data: List<Video.Item>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewGroup = inflater.inflate(R.layout.fragement_rv, container, false)

        rv.apply {
            layoutManager = LinearLayoutManager(viewGroup.context)
            itemAnimator = DefaultItemAnimator()
        }

        VideoServiceImpl.service.getData(part, fieds, maxresults, playlistid, Key.API_KEY)
            .enqueue(object : Callback<Video>{
                override fun onFailure(call: Call<Video>, t: Throwable) {
                    Log.d("debug","실패: t")
                }

                override fun onResponse(call: Call<Video>, response: Response<Video>) {
                    data = response.takeIf { it.isSuccessful }?.body()?.items!!
                    rv.adapter = VideoAdapter(viewGroup.context, data)
                }
            })

        return viewGroup
    }

}