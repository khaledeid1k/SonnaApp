package com.sonna.local.model

import androidx.room.Entity

@Entity(tableName = "hadith_book_model", primaryKeys = ["number","hadith" ])
data class HadithModel(
    val number: Int,
    val hadith: String,
    val description: String,
    val searchTerm: String
    )
