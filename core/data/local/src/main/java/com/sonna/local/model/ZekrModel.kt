package com.sonna.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ZekrModel(
    val category: String,
    val count: String,
    val zekr: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
)

