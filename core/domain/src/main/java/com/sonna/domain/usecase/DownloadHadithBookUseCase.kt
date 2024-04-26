package com.sonna.domain.usecase

import com.sonna.domain.entity.hadith.HadithBookNames
import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.repository.ContentRepository


class DownloadHadithBookUseCase(private val contentRepository: ContentRepository) {

    suspend operator fun invoke(hadithBookName: HadithBookNames) =
        isHadithBookDownloaded(hadithBookName)

    private suspend fun isHadithBookDownloaded(hadithBookName: HadithBookNames) {

        contentRepository.downloadFile(
            "https://raw.githubusercontent.com/khaledeid1k/repos_server/main/Hadith/abi_daud.json",
            hadithBookName.name
        )
        //  downloadHadithBook(contentRepository.isHadithBookDownloaded(hadithBookName), hadithBookName)
    }

    private suspend fun downloadHadithBook(isDownloaded: Boolean, hadithBookName: HadithBookNames) {
        if (!isDownloaded) {
            val hadithBook = contentRepository.getHadithBook(hadithBookName)
            // Todo( after download finish save in data base)
            saveHadithBookToDataBase(hadithBook, hadithBookName.name)
        } else {
            saveSelectedHadithBook(hadithBookName.name)
        }
    }

    private suspend fun saveSelectedHadithBook(hadithBookName: String) {
        contentRepository.saveSelectedHadithBook(hadithBookName)
    }

    private suspend fun saveHadithBookToDataBase(
        hadithBook: List<HadithEntity>,
        hadithBookName: String
    ) {
        contentRepository.saveHadithBook(hadithBook)
        // ToDo( after data saved into data base save selected hadith name)
        saveSelectedHadithBook(hadithBookName)
    }

    suspend fun asdsadsad() {
        val readSelectedHadithBook = contentRepository.readSelectedHadithBook()
    }

    suspend fun asasd(hadithBookName: HadithBookNames) {
        contentRepository.isHadithBookDownloaded(hadithBookName)
    }
}