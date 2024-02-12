package com.sonna.local

import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel
import kotlinx.coroutines.flow.flow

class CoreLocalDataSourceImp(
    private val coreDao: CoreDao,
) : CoreLocalDataSource {
    override suspend fun insertSurah(surahModel: SurahModel) = flow { emit(coreDao.insertSurah(surahModel)) }
    override suspend fun insertZekr(zekrModel: ZekrModel) = coreDao.insertZekr(zekrModel)
    override suspend fun getAzkar() = flow { emit(coreDao.getAzkar()) }
}