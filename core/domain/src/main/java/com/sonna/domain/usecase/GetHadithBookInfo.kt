package com.sonna.domain.usecase

import com.sonna.domain.repository.ContentRepository

class GetHadithBookInfo(private val contentRepository: ContentRepository){
    suspend operator fun invoke() = getNumberHadithBook()
    private suspend fun getNumberHadithBook(): Pair<String, Int> {
        return contentRepository.readSelectedHadithBook()
    }

}