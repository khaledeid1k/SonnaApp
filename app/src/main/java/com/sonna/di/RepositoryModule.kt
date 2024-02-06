package com.sonna.di

import com.sonna.domain.repository.CoreRepository
import com.sonna.local.CoreLocalDataSource
import com.sonna.remote.CoreRemoteDataSource
import com.sonna.repository.CoreRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideCoreRepository(coreRemoteDataSource: CoreRemoteDataSource, coreLocalDataSource: CoreLocalDataSource): CoreRepository {
        return CoreRepositoryImp(
            coreRemoteDataSource,
            coreLocalDataSource
        )
    }
}
