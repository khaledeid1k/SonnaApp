package com.sonna.viewmodel.details

import com.sonna.domain.entity.quran.AyahEntity

fun AyahEntity.toState(): AyaState = AyaState(
    index = number,
    text = text,
    sajda = sajda
)