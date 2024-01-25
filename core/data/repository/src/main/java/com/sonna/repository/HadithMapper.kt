package com.sonna.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.remote.response.hadith.HadithResponse

fun HadithResponse.toEntity(): List<HadithEntity> {
    return this.map {
        HadithEntity(
            hadith = it.hadith,
            description = it.description,
            number = it.number
        )
    }
}