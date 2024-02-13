package com.sonna.domain.repository

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.hadith.HadithBookDownloadedEntity
import com.sonna.domain.entity.quran.AllSurahesEntity
import com.sonna.domain.entity.quran.SurahEntity

interface ContentRepository {
    suspend fun getSurahes(): AllSurahesEntity
    suspend fun getAzkar(fromLocal:Boolean): AzkarEntity
    suspend fun getSLastHadith(): String
    suspend fun insertSurah(surahEntity: SurahEntity):Long
    suspend fun insertZekr(zekrEntity: ZekrEntity):Long

    suspend  fun saveSelectedHadithBook(hadithBook: String)
    suspend  fun readSelectedHadithBook(): Pair<String,Int>
    suspend fun getHadithBook(hadithName:String): List<HadithEntity>


    suspend fun saveHadithBook(hadithBook : List<HadithEntity>): List<Long>
    suspend fun getSingleHadith(hadithBookName: String, numberOfHadith:Int): HadithEntity

    suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedEntity):Long
    suspend fun isHadithBookDownloaded(hadithBookName: String): Boolean
}