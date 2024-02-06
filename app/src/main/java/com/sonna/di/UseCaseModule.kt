package com.sonna.di

import com.sonna.domain.repository.CoreRepository
import com.sonna.domain.usecase.GetAzkarUseCase
import com.sonna.domain.usecase.GetQuranUseCase
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
    fun provideGetGetQuranUseCase(coreRepository: CoreRepository): GetQuranUseCase {
        return GetQuranUseCase(coreRepository)
    }

    @Provides
    fun provideInsertSurahUseCase(coreRepository: CoreRepository): InsertSurahUseCase {
        return InsertSurahUseCase(coreRepository)
    }

    @Provides
    fun provideGetAzkarUseCase(coreRepository: CoreRepository): GetAzkarUseCase {
        return GetAzkarUseCase(coreRepository)
    }
    @Provides
    fun provideInsertZekrUseCase(coreRepository: CoreRepository): InsertZekrUseCase {
        return InsertZekrUseCase(coreRepository)
    }
}
