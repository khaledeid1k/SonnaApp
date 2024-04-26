package com.sonna.domain.entity.hadith

data class HadithEntity(
    val hadith: String,
    val description: String,
    val number: Int,
    val searchTerm: String,
)

//enum class HadithBookNames { Darimi, Ahmed, AbiDaud, Bukhari, IbnMaja, Malik, Muslim, Nasai, Trmizi; }
//todo what best solution for save hadith books names
enum class HadithBookNames(val numberOfHadithBook: Int) {
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
        fun fromName(name: String): HadithBookNames {
            return entries.first { it.name == name }
        }
    }
}
