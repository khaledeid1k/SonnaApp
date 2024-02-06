package com.sonna.domain.usecase

import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.repository.CoreRepository

class InsertZekrUseCase(
    private val coreRepository: CoreRepository
) {
    suspend operator fun invoke(zekrEntity: ZekrEntity) = coreRepository.insertZekr(zekrEntity)
}