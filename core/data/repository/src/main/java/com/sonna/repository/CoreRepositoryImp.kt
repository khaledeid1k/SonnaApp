package com.sonna.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.CoreRepository
import com.sonna.local.CoreLocalDataSource
import com.sonna.remote.CoreRemoteDataSource

class CoreRepositoryImp(
    private val coreRemoteDataSource: CoreRemoteDataSource,
    private val coreLocalDataSource: CoreLocalDataSource
) : CoreRepository {
    override suspend fun getQuran() = coreRemoteDataSource.getQuran().toEntity()

    override suspend fun getAzkar(fromLocal: Boolean): AzkarEntity {
        return if (fromLocal) {
            AzkarEntity(coreLocalDataSource.getAzkar().map { it.toEntity() })
        } else {
            coreRemoteDataSource.getAzkar().toEntity()
        }
    }

    override suspend fun insertSurah(surahEntity: SurahEntity) =
        coreLocalDataSource.insertSurah(surahEntity.toModel())

    override suspend fun insertZekr(zekrEntity: ZekrEntity) =
        coreLocalDataSource.insertZekr(zekrEntity.toModel())
}