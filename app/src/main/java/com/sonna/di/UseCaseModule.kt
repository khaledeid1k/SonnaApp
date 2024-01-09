package com.sonna.di

import com.giraffe.domain.repository.ContentRepository
import com.giraffe.domain.usecase.GetSurahesUseCase
import com.giraffe.domain.usecase.InsertSurahUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetSurahesUseCase(contentRepository: ContentRepository): GetSurahesUseCase {
        return GetSurahesUseCase(contentRepository)
    }

    @Provides
    fun provideInsertSurahUseCase(contentRepository: ContentRepository): InsertSurahUseCase {
        return InsertSurahUseCase(contentRepository)
    }
}
