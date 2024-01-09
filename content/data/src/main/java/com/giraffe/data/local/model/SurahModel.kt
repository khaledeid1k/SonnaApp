package com.giraffe.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SurahModel(
    @PrimaryKey
    val englishName: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
)