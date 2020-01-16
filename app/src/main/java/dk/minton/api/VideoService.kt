package dk.minton.api

import dk.minton.data.Video
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {
    @GET("youtube/v3/playlistItems")
    fun getData(
        @Query("part") part: String, @Query("fields") fields: String, @Query("maxResults") maxResults: String, @Query(
            "playlistId"
        ) id: String, @Query("key") key: String
    ): Call<Video>
}