package dk.minton.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VideoServiceImpl {
    const val BASE_URL = "https://www.googleapis.com/"

    val service = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(VideoService::class.java)
}