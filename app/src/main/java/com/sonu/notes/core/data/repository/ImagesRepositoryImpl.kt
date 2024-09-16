package com.sonu.notes.core.data.repository

import com.sonu.notes.core.data.mapper.toImages
import com.sonu.notes.core.data.remote.api.ImagesApi
import com.sonu.notes.core.domain.model.Images
import com.sonu.notes.core.domain.repository.ImagesRepository
import javax.inject.Inject


class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesRepository {

    override suspend fun searchImages(
        query: String
    ): Images? {
        return imagesApi.searchImages(query)?.toImages()
    }

}


















