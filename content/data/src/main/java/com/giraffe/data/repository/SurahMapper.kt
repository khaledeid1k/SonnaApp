package com.giraffe.data.repository

import com.giraffe.data.local.model.SurahModel
import com.giraffe.data.remote.response.quran.AllSurahesResponse
import com.giraffe.data.remote.response.quran.SurahResponse
import com.giraffe.domain.entity.quran.AllSurahesEntity
import com.giraffe.domain.entity.quran.SurahEntity

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