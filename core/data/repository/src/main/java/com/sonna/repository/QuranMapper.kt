package com.sonna.repository

import com.sonna.domain.entity.quran.AyahEntity
import com.sonna.domain.entity.quran.QuranEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.local.model.AyahModel
import com.sonna.local.model.SurahModel
import com.sonna.remote.response.quran.AyahResponse
import com.sonna.remote.response.quran.QuranResponse
import com.sonna.remote.response.quran.SurahResponse

fun QuranResponse.toEntity(): QuranEntity {
    return QuranEntity(
        surahes = data.surahs.map {
            it.toEntity()
        }
    )
}

private fun SurahResponse.toEntity(): SurahEntity {
    return SurahEntity(
        ayahs = this.ayahs.map { it.toEntity() },
        englishName = this.englishName,
        englishNameTranslation = this.englishNameTranslation,
        name = this.name,
        number = this.number,
        revelationType = this.revelationType
    )
}

private fun AyahResponse.toEntity(): AyahEntity {
    return AyahEntity(
        hizbQuarter = this.hizbQuarter,
        juz = this.juz,
        manzil = this.manzil,
        number = this.number,
        numberInSurah = this.numberInSurah,
        page = this.page,
        ruku = this.ruku,
        sajda = this.sajda !is Boolean,
        text = this.text
    )
}

fun SurahEntity.toModel(): SurahModel {
    return SurahModel(
        ayahs = this.ayahs.map { it.toModel() },
        englishName = this.englishName,
        englishNameTranslation = this.englishNameTranslation,
        name = this.name,
        number = this.number,
        revelationType = this.revelationType
    )
}

fun AyahEntity.toModel(): AyahModel {
    return AyahModel(
        hizbQuarter = this.hizbQuarter,
        juz = this.juz,
        manzil = this.manzil,
        number = this.number,
        numberInSurah = this.numberInSurah,
        page = this.page,
        ruku = this.ruku,
        sajda = this.sajda,
        text = this.text
    )
}

fun SurahModel.toEntity(): SurahEntity {
    return SurahEntity(
        ayahs = this.ayahs.map { it.toEntity() },
        englishName = this.englishName,
        englishNameTranslation = this.englishNameTranslation,
        name = this.name,
        number = this.number,
        revelationType = this.revelationType
    )
}

fun AyahModel.toEntity(): AyahEntity {
    return AyahEntity(
        hizbQuarter = this.hizbQuarter,
        juz = this.juz,
        manzil = this.manzil,
        number = this.number,
        numberInSurah = this.numberInSurah,
        page = this.page,
        ruku = this.ruku,
        sajda = this.sajda,
        text = this.text
    )
}