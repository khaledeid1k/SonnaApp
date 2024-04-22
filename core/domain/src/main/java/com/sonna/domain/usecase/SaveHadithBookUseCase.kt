package com.sonna.domain.usecase

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.repository.ContentRepository

class SaveHadithBookUseCase(private val contentRepository: ContentRepository) {

    suspend operator fun invoke(hadithBookName: String) = isHadithBookDownloaded(hadithBookName)
    private suspend fun isHadithBookDownloaded(hadithBookName: String) {
        downloadHadithBook(contentRepository.isHadithBookDownloaded(hadithBookName), hadithBookName)
    }
    private suspend fun downloadHadithBook(isDownloaded: Boolean, hadithBookName: String) {
        if (!isDownloaded) {
            val hadithBook = contentRepository.getHadithBook(hadithBookName)
            // ToDo( after download finish save in data base)
            saveHadithBookToDataBase(hadithBook,hadithBookName)
        } else {
            saveSelectedHadithBook(hadithBookName)
        }
    }
    private suspend fun saveSelectedHadithBook(hadithBookName: String) {
        contentRepository.saveSelectedHadithBook(hadithBookName)
    }

    private suspend fun saveHadithBookToDataBase(
        hadithBook: List<HadithEntity>,
        hadithBookName:String) {
        contentRepository.saveHadithBook(hadithBook)
        // ToDo( after data saved into data base save selected hadith name)
        saveSelectedHadithBook(hadithBookName)
    }
}