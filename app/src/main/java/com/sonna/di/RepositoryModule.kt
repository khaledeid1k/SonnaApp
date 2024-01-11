package com.sonna.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideContentRepository(contentRemoteDataSource: com.sonna.data.remote.ContentRemoteDataSource, contentLocalDataSource: com.sonna.data.local.ContentLocalDataSource): com.sonna.domain.repository.ContentRepository {
        return com.sonna.data.repository.ContentRepositoryImp(
            contentRemoteDataSource,
            contentLocalDataSource
        )
    }
}
