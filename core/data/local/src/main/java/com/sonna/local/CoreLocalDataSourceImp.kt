package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel
import kotlinx.coroutines.flow.flow

class CoreLocalDataSourceImp(
    private val contentDao: ContentDao,
) : CoreLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = contentDao.insertSurah(surahModel)
    override suspend fun insertZekr(zekrModel: ZekrModel) = contentDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = flow { emit(contentDao.getAzkar()) }
}