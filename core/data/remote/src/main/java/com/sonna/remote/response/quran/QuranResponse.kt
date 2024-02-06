package com.sonna.remote.response.quran

data class QuranResponse(
    val code: Int,
    val `data`: DataResponse,
    val status: String
)

data class DataResponse(
    val edition: EditionResponse,
    val surahs: List<SurahResponse>
)

data class EditionResponse(
    val englishName: String,
    val format: String,
    val identifier: String,
    val language: String,
    val name: String,
    val type: String
)

data class SurahResponse(
    val ayahs: List<AyahResponse>,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val revelationType: String
)

data class AyahResponse(
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