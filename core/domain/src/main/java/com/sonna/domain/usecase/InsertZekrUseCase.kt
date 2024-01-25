package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.repository.ContentRepository

class InsertZekrUseCase(
    private val contentRepository: ContentRepository
) {
    suspend operator fun invoke(zekrEntity: ZekrEntity) = contentRepository.insertZekr(zekrEntity)
}