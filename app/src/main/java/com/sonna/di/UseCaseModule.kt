package com.sonna.di

import com.sonna.domain.repository.ContentRepository
import com.sonna.domain.usecase.GetHadithBookUseCase
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetLastHadith
import com.sonna.domain.usecase.GetSurahesUseCase
import com.sonna.domain.usecase.InsertSurahUseCase
import com.sonna.domain.usecase.InsertZekrUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
    fun provideLastHadithUseCase(contentRepository: ContentRepository): GetLastHadith {
        return GetLastHadith(contentRepository)
    }

    @Provides
    fun provideGetHadithBook(contentRepository: ContentRepository): GetHadithBookUseCase {
        return GetHadithBookUseCase(contentRepository)
    }

    @Provides
    fun provideGetAzkarUseCase(contentRepository: ContentRepository): GetAzkarUseCase {
        return GetAzkarUseCase(contentRepository)
    }
    @Provides
    fun provideInsertZekrUseCase(contentRepository: ContentRepository): InsertZekrUseCase {
        return InsertZekrUseCase(contentRepository)
    }
}
