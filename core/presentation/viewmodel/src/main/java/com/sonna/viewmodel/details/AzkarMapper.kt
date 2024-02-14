package com.sonna.viewmodel.details

import com.sonna.domain.entity.azkar.ZekrEntity
import com.sonna.domain.entity.quran.AyahEntity

fun ZekrEntity.toState(): ZekrState = ZekrState(
    text = zekr,
    count = count
)