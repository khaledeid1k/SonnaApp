package com.sonna.di

import com.sonna.domain.repository.ContentRepository
import com.sonna.local.ContentLocalDataSource
import com.sonna.remote.ContentRemoteDataSource
import com.sonna.repository.ContentRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideContentRepository(contentRemoteDataSource: ContentRemoteDataSource, contentLocalDataSource: ContentLocalDataSource): ContentRepository {
        return ContentRepositoryImp(
            contentRemoteDataSource,
            contentLocalDataSource
        )
    }
}
