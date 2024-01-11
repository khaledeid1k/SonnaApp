package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetSurahesUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke() = contentRepository.getSurahes()
}