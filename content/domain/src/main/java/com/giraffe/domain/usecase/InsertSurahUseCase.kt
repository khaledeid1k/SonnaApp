package com.giraffe.domain.usecase

import com.giraffe.domain.entity.quran.SurahEntity
import com.giraffe.domain.repository.ContentRepository

class InsertSurahUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke(surahEntity: SurahEntity) = contentRepository.insertSurah(surahEntity)
}