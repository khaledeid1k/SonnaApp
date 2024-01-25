package com.sonna.remote.response.hadith

data class HadithResponseItem(
    val description: String,
    val hadith: String,
    val number: Int,
    val searchTerm: String
)