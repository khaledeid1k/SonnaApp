package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetHadithBookInfoUseCase(private val contentRepository: ContentRepository){
    suspend operator fun invoke() = getNumberHadithBook()
    private suspend fun getNumberHadithBook(): Pair<String, Int> {
        return contentRepository.readSelectedHadithBook()
    }

}