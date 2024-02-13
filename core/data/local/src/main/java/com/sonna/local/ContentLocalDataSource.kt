package com.sonna.local

import com.sonna.local.model.HadithBookDownloadedModel
import com.sonna.local.model.HadithBookModel
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
    suspend  fun readSelectedHadithBookName(): String
    suspend  fun saveSelectedHadithBook(hadithBook: String)
    suspend fun insertZekr(zekrModel: ZekrModel):Long
    suspend fun getAzkar():List<ZekrModel>
    suspend fun saveHadithBook(hadithBook : List<HadithBookModel>): List<Long>
    suspend fun getSingleHadith(hadith: String, numberOfHadith:Int): HadithBookModel

    suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedModel):Long
    suspend fun isHadithBookDownloaded(hadithBookName: String): Boolean


}