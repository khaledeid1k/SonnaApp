package com.sonna.screens.content

data class ContentState(
    val lastSurahName:String,
    val lastVerseNum:Int,
    val tabs:List<String> = listOf("Quran","Hadith"),
    val surahesList:List<SurahState> = emptyList()
)

data class SurahState(
    val index:Int,
    val name:String,
    val englishName:String,
    val numOfVerses:Int
)
