package com.sonna.di

import com.sonna.domain.repository.ContentRepository
import com.sonna.domain.usecase.GetLastHadith
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
    fun provideGetSurahesUseCase(contentRepository: ContentRepository): GetSurahesUseCase {
        return GetSurahesUseCase(contentRepository)
    }

    @Provides
    fun provideInsertSurahUseCase(contentRepository: ContentRepository): InsertSurahUseCase {
        return InsertSurahUseCase(contentRepository)
    }

    @Provides
    fun provideLAstHadithUseCase(contentRepository: ContentRepository): GetLastHadith {
        return GetLastHadith(contentRepository)
    }
}
