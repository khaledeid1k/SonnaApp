package com.sonna.mapper

import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.local.model.SurahModel
import com.sonna.remote.response.quran.AllSurahesResponse
import com.sonna.remote.response.quran.SurahResponse

fun AllSurahesResponse.toEntity(): AllSurahesEntity {
    return AllSurahesEntity(
        this.data.map {
            it.toEntity()
        }
    )
}

private fun SurahResponse.toEntity(): SurahEntity {
    return SurahEntity(
        this.englishName,
        this.name,
        this.number,
        this.numberOfAyahs
    )
}

fun SurahEntity.toModel(): SurahModel {
    return SurahModel(
        englishName = englishName,
        name = name,
        number = number,
        numberOfAyahs = numberOfAyahs
    )
}