package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

class ContentLocalDataSourceImp(
    private val contentDao: ContentDao,
) : ContentLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
    override suspend fun insertZekr(zekrModel: ZekrModel) = contentDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = contentDao.getAzkar()
}