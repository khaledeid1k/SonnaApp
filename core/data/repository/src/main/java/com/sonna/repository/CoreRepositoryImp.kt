package com.sonna.repository

import com.sonna.common.bases.BaseRepository
import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.CoreRepository
import com.sonna.local.CoreLocalDataSource
import com.sonna.remote.CoreRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoreRepositoryImp(
    private val coreRemoteDataSource: CoreRemoteDataSource,
    private val coreLocalDataSource: CoreLocalDataSource
) : CoreRepository, BaseRepository() {
    override suspend fun getQuran() =
        wrapResponseWithErrorHandler { coreRemoteDataSource.getQuran() }.map { it.toEntity() }

    override suspend fun getAzkar(fromLocal: Boolean): Flow<AzkarEntity> {
        return if (fromLocal) {
            wrapLocalResponseWithErrorHandler { coreLocalDataSource.getAzkar() }
                .map {
                    AzkarEntity(it.map { model -> model.toEntity() })
                }
        } else {
            wrapResponseWithErrorHandler { coreRemoteDataSource.getAzkar() }.map { it.toEntity() }
        }
    }

    override suspend fun insertSurah(surahEntity: SurahEntity) =
        wrapLocalResponseWithErrorHandler { coreLocalDataSource.insertSurah(surahEntity.toModel()) }

    override suspend fun insertZekr(zekrEntity: ZekrEntity) =
        coreLocalDataSource.insertZekr(zekrEntity.toModel())
}