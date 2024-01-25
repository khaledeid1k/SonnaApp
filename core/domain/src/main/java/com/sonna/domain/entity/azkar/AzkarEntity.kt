package com.sonna.domain.entity.azkar

data class AzkarEntity(
    val azkarList : List<AzkarEntityItem>
)

data class AzkarEntityItem(
    val category: String,
    val count: String,
    //val description: String,
    //val reference: String,
    val zekr: String
)