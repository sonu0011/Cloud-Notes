package com.sonu.notes.core.data.mapper

import com.sonu.notes.core.data.remote.dto.ImageListDto
import com.sonu.notes.core.domain.model.Images



fun ImageListDto.toImages(): Images {
    return Images(
        images = hits?.map { imageDto ->
            imageDto.previewURL ?: ""
        } ?: emptyList()
    )
}

















