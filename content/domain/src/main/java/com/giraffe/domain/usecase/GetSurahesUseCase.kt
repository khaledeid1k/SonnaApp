package com.giraffe.domain.usecase

import com.giraffe.domain.repository.ContentRepository

class GetSurahesUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke() = contentRepository.getSurahes()
}