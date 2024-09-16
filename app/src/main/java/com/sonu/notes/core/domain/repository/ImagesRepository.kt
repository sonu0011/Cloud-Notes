package com.sonu.notes.core.domain.repository

import com.sonu.notes.core.domain.model.Images

interface ImagesRepository {

    suspend fun searchImages(query: String): Images?

}