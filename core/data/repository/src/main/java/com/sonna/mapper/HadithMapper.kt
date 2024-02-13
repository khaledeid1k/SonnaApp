package com.sonna.mapper

import com.sonna.domain.entity.hadith.HadithEntity
import com.sonna.local.model.HadithModel
import com.sonna.remote.response.hadith.HadithResponse

fun HadithResponse.toEntity(): List<HadithEntity> {
    return this.map {
        HadithEntity(
            hadith = it.hadith,
            description = it.description,
            number = it.number,
            searchTerm = it.searchTerm
        )
    }
}

fun HadithModel.toEntity(): HadithEntity{
    return HadithEntity(
            hadith = hadith,
            description = description,
            number = number,
            searchTerm = searchTerm
        )

}

fun List<HadithEntity>.toModel() :List<HadithModel>{
    return this.map {
        HadithModel(
            hadith = it.hadith,
            description = it.description,
            number = it.number,
            searchTerm = it.searchTerm
        )
    }
}