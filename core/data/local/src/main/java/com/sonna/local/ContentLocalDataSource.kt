package com.sonna.local

import com.sonna.domain.entity.hadith.HadithBookNames
import com.sonna.local.model.HadithBookDownloadedModel
import com.sonna.local.model.HadithModel
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

interface ContentLocalDataSource {
    suspend fun insertSurah(surahModel: SurahModel):Long
    suspend  fun readSelectedHadithBookName(): String
    suspend  fun saveSelectedHadithBook(hadithBook: String)
    suspend fun insertZekr(zekrModel: ZekrModel):Long
    suspend fun getAzkar():List<ZekrModel>
    suspend fun saveHadithBook(hadithBook : List<HadithModel>): List<Long>
    suspend fun getSingleHadith(hadith: String, numberOfHadith:Int): HadithModel

    suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedModel):Long
    suspend fun isHadithBookDownloaded(hadithBookName: HadithBookNames): Boolean


}