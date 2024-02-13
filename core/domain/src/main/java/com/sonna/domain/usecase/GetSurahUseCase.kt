package com.sonna.domain.usecase

import com.sonna.domain.repository.CoreRepository

class GetSurahUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(surahIndex: Int) = coreRepository.getSurah(surahIndex)
}