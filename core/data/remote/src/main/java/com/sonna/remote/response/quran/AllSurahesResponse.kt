package com.sonna.remote.response.quran

data class AllSurahesResponse(
    val code: Int,
    val `data`: List<SurahResponse>,
    val status: String
)

data class SurahResponse(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)