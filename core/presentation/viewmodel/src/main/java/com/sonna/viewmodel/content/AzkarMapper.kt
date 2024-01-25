package com.sonna.viewmodel.content

import com.sonna.domain.entity.azkar.AzkarCategoryEntity

fun AzkarCategoryEntity.toState(): AzkarCategoryState = AzkarCategoryState(
    name = this.name,
    numberOfAzkar = this.numberOfAzkar
)