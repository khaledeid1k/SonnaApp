package com.sonna.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hadith_book_names")
data class HadithBookDownloadedModel(@PrimaryKey val hadithBookName: String)



