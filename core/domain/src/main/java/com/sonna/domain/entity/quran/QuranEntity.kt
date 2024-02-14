package com.sonna.domain.entity.quran

data class QuranEntity(
    val surahes: List<SurahEntity>
)

data class SurahEntity(
    val ayahs: List<AyahEntity>,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val revelationType: String
)

data class AyahEntity(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Boolean,
    var text: String
)