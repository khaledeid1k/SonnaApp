package com.sonna.viewmodel.setting_details.hadith

class HadithSettingState {
    val hadithDialogSettingState: HadithDialogSettingState = HadithDialogSettingState()
}

class HadithDialogSettingState {
    val hadithBooks: List<HadithDownloadState> = listOf(
        HadithDownloadState("Darimi", true),
        HadithDownloadState("Ahmed"),
        HadithDownloadState("AbiDaud"),
        HadithDownloadState("Bukhari"),
        HadithDownloadState("IbnMaja"),
        HadithDownloadState("Malik"),
        HadithDownloadState("Muslim"),
        HadithDownloadState("Nasai"),
        HadithDownloadState("Trmizi"),
    )
    val selectedHadithBookName: String = "Darimi"
}

data class HadithDownloadState(
    val hadithBookText: String, val download: Boolean = false
)