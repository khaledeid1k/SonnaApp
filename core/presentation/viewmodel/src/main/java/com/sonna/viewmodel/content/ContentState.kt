package com.sonna.viewmodel.content

data class ContentState(
    val lastSurahName: String = "",
    val lastVerseNum: Int = 0,
    val selectedTabIndex: Int = 0,
    val tabs: List<String> = listOf("Quran", "Hadith", "Azkar"),
    val azkarList: List<AzkarCategoryState> = emptyList(),
    val surahesList: List<ContentDetailsState> = emptyList(),
    val hadithBookInfo: Pair<String,Int> = Pair("",0)
    )


data class ContentDetailsState(
    val englishName: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
)

data class AzkarCategoryState(
    val name: String,
    val numberOfAzkar: Int,
)