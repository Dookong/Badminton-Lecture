package dk.iutube.api

import dk.iutube.data.Video
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {
    @GET("youtube/v3/playlistItems")
    fun getData(
        @Query("part") part: String, @Query("fields") fields: String, @Query("maxResults") maxResults: Int, @Query(
            "playlistId"
        ) id: String, @Query("key") key: String
    ): Call<Video>
}