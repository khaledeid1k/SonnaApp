package com.sonna.domain.entity.azkar

class AzkarEntity : ArrayList<AzkarEntityItem>()

data class AzkarEntityItem(
    val category: String,
    val count: String,
    //val description: String,
    //val reference: String,
    val zekr: String
)