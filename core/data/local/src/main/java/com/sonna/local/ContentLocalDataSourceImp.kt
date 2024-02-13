package com.sonna.local

import com.sonna.local.data_store.SonnaDataStorePreferences
import com.sonna.local.model.HadithBookDownloadedModel
import com.sonna.local.model.HadithModel
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
    private val sonnaDataStorePreferences: SonnaDataStorePreferences
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
    override suspend fun readSelectedHadithBookName(): String {
       return sonnaDataStorePreferences.readSelectedHadithBookName()
    }

    override suspend fun saveSelectedHadithBook(hadithBook: String) {
        sonnaDataStorePreferences.saveSelectedHadithBookName(hadithBook)
    }
    override suspend fun insertZekr(zekrModel: ZekrModel) = contentDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = contentDao.getAzkar()
    override suspend fun saveHadithBook(hadithBook: List<HadithModel>) : List<Long> {
      return  contentDao.saveHadithBook(hadithBook)
    }


    override suspend fun getSingleHadith(
        hadith: String,
        numberOfHadith: Int
    ): HadithModel {
        return contentDao.getSingleHadith(hadith, numberOfHadith)
    }

    override suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedModel): Long {
       return contentDao.saveDownloadedHadithBookName(hadithBookDownloadedModel)
    }

    override suspend fun isHadithBookDownloaded(hadithBookName: String): Boolean {
       return contentDao.isHadithBookDownloaded(hadithBookName)
    }

}