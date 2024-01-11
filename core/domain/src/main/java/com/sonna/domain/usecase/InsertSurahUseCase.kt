package com.sonna.domain.usecase

import com.sonna.domain.entity.quran.SurahEntity
import com.sonna.domain.repository.ContentRepository

class InsertSurahUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke(surahEntity: SurahEntity) = contentRepository.insertSurah(surahEntity)
}