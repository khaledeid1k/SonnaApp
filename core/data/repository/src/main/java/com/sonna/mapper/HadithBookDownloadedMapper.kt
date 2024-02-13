package com.sonna.mapper

import com.sonna.domain.entity.hadith.HadithBookDownloadedEntity
import com.sonna.local.model.HadithBookDownloadedModel

fun HadithBookDownloadedEntity.toEntity(): HadithBookDownloadedModel {
    return HadithBookDownloadedModel(name)
}