package com.sonna.data.repository

import com.sonna.data.local.model.SurahModel
import com.sonna.data.remote.response.quran.AllSurahesResponse
import com.sonna.data.remote.response.quran.SurahResponse
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity

fun AllSurahesResponse.toEntity(): AllSurahesEntity {
    return AllSurahesEntity(
        this.data.map {
            it.toEntity()
        }
    )
}

private fun SurahResponse.toEntity(): com.sonna.domain.entity.quran.SurahEntity {
    return com.sonna.domain.entity.quran.SurahEntity(
        this.englishName,
        this.name,
        this.number,
        this.numberOfAyahs
    )
}

fun com.sonna.domain.entity.quran.SurahEntity.toModel(): SurahModel {
    return SurahModel(
        englishName = englishName,
        name = name,
        number = number,
        numberOfAyahs = numberOfAyahs
    )
}