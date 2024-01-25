package com.sonna.repository

import com.sonna.domain.entity.azkar.AzkarEntity
import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.local.model.ZekrModel
import com.sonna.remote.response.azkar.AzkarResponse
import com.sonna.remote.response.azkar.AzkarResponseItem

fun AzkarResponse.toEntity(): AzkarEntity {
    return AzkarEntity(this.map { it.toEntity() })
}

private fun AzkarResponseItem.toEntity(): ZekrEntity {
    return ZekrEntity(
        this.category,
        this.count,
        this.zekr,
    )
}

fun ZekrEntity.toModel(): ZekrModel {
    return ZekrModel(
        category = this.category,
        count = this.count,
        zekr = this.zekr
    )
}

fun ZekrModel.toEntity(): ZekrEntity {
    return ZekrEntity(
        category = this.category,
        count = this.count,
        zekr = this.zekr
    )
}