package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetHadithBookUseCase(private val contentRepository: ContentRepository) {
    suspend operator fun invoke() = contentRepository.getHadithBook()

}