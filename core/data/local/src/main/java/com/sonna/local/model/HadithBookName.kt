package com.sonna.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hadith_book_names")
data class HadithBookDownloadedModel(@PrimaryKey val hadithBookName: String)

enum class HadithBookNames (val numberOfHadithBook:Int){
    Darimi(3367),
    Ahmed(26363),
    AbiDaud(4590),
    Bukhari(7008),
    IbnMaja(4332),
    Malik(1594),
    Muslim(5362),
    Nasai(5662),
    Trmizi(3891);
    companion object {
        fun fromName(name: String): HadithBookNames{
            return values().first{ it.name == name }
        }
    }
}

