package com.sonna.di

import com.giraffe.data.local.ContentLocalDataSource
import com.giraffe.data.remote.ContentRemoteDataSource
import com.giraffe.data.repository.ContentRepositoryImp
import com.giraffe.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideContentRepository(contentRemoteDataSource: ContentRemoteDataSource, contentLocalDataSource: ContentLocalDataSource): ContentRepository {
        return ContentRepositoryImp(contentRemoteDataSource,contentLocalDataSource)
    }
}
