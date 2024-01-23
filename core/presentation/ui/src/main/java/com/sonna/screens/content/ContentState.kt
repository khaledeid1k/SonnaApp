package com.sonna.screens.content

data class ContentState(
    val lastSurahName: String = "",
    val lastVerseNum: Int = 0,
    val tabs: List<String> = listOf("Quran", "Hadith", "Azkar"),
    val surahesList: List<SurahState> = emptyList()
)

data class SurahState(
    val index: Int = 0,
    val name: String = "",
    val englishName: String = "",
    val numOfVerses: Int = 0
)
