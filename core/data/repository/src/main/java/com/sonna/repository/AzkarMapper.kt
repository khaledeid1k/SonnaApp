package com.sonna.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.AzkarEntityItem
import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.azkar.AzkarResponseItem

fun AzkarResponse.toEntity(): AzkarEntity {
    return AzkarEntity(this.map { it.toEntity() })
}

private fun AzkarResponseItem.toEntity(): AzkarEntityItem {
    return AzkarEntityItem(
        this.category,
        this.count,
        this.zekr,
    )
}