package com.sonna.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SurahModel(
    val ayahs: List<AyahModel>,
    @PrimaryKey
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val revelationType: String
)

data class AyahModel(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Any,
    val text: String
)