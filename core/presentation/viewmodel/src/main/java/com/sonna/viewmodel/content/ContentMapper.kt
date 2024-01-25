package com.sonna.viewmodel.content

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.domain.entity.quran.SurahEntity

fun SurahEntity.toState():ContentDetailsState = ContentDetailsState(
    number = this.number,
    name = this.name,
    englishName = this.englishName,
    numberOfAyahs = this.numberOfAyahs
)

fun List<HadithEntity>.toState():List<ContentDetailsState>{
   return this.map { ContentDetailsState(
       number = it.number,
       englishName=it.description,
       numberOfAyahs=it.number,
       name=it.hadith,

       ) }
}
