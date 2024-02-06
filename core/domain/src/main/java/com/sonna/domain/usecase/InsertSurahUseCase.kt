package com.sonna.domain.usecase

import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.CoreRepository

class InsertSurahUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(surahEntity: SurahEntity) = coreRepository.insertSurah(surahEntity)
}