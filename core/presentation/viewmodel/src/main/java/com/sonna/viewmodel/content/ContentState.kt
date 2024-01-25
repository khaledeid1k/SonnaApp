package com.sonna.viewmodel.content

import com.sonna.domain.entity.quran.SurahEntity

data class ContentState(
    val lastSurahName: String = "",
    val lastVerseNum: Int = 0,
    val selectedTabIndex: Int = 0,
    val tabs: List<String> = listOf("Quran", "Hadith", "Azkar"),
    val surahesList: List<SurahState> = emptyList(),
    val azkarList: List<AzkarCategoryState> = emptyList()
)

data class SurahState(
    val englishName: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
)

data class AzkarCategoryState(
    val name: String,
    val numberOfAzkar: Int,
)