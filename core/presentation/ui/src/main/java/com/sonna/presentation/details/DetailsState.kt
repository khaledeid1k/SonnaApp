package com.sonna.presentation.details

data class DetailsState(
    val hasBasmala: Boolean = true,
    val surahName: String = "الفاتحة",
    val verses: List<VerseState> = emptyList()
)

data class VerseState(
    val arabicVerse: String,
    val englishVerse: String,
)