package com.sonna.viewmodel.content

import com.sonna.domain.entity.quran.SurahEntity

fun SurahEntity.toState():ContentDetailsState = ContentDetailsState(
    number = this.number,
    name = this.name,
    englishName = this.englishName,
    numberOfAyahs = this.numberOfAyahs
)


