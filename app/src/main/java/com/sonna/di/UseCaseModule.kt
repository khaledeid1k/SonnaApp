package com.sonna.di

import com.sonna.domain.repository.ContentRepository
import com.sonna.domain.usecase.GetSurahesUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetSurahesUseCase(contentRepository: com.sonna.domain.repository.ContentRepository): com.sonna.domain.usecase.GetSurahesUseCase {
        return com.sonna.domain.usecase.GetSurahesUseCase(contentRepository)
    }

    @Provides
    fun provideInsertSurahUseCase(contentRepository: com.sonna.domain.repository.ContentRepository): com.sonna.domain.usecase.InsertSurahUseCase {
        return com.sonna.domain.usecase.InsertSurahUseCase(contentRepository)
    }
}
