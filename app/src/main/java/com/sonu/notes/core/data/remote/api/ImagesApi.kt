package com.sonu.notes.core.data.remote.api

import com.sonu.notes.core.data.remote.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query


interface ImagesApi {

    @GET("/api/")
    suspend fun searchImages(
        @Query("q") query: String,
        @Query("key") apiKey: String = API_KEY,
    ): ImageListDto?

    companion object {
        const val BASE_URL = "https://pixabay.com"
        const val API_KEY = "45987615-cd20dc46894ea8b88541f2965"
    }

}





















