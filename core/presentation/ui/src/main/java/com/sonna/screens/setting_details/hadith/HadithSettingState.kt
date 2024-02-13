package com.sonna.screens.setting_details.hadith

class HadithSettingState {
    val hadithBooks:List<HadithDownloadState> = listOf(
        HadithDownloadState("Darimi"),
        HadithDownloadState("Ahmed"),
        HadithDownloadState("AbiDaud"),
        HadithDownloadState("Bukhari"),
        HadithDownloadState("IbnMaja"),
        HadithDownloadState("Malik"),
        HadithDownloadState("Muslim"),
        HadithDownloadState("Nasai"),
        HadithDownloadState("Trmizi"),
    )
}

data class HadithDownloadState(
   val  hadithBook:String, val download:Boolean=false
)