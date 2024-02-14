package com.sonna.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

@Dao
interface CoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(surahModel: SurahModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZekr(zekrModel: ZekrModel): Long

    @Query("SELECT * FROM zekrmodel")
    suspend fun getAzkar(): List<ZekrModel>

    @Query("SELECT * FROM zekrmodel WHERE category = :category")
    suspend fun getAzkar(category: String): List<ZekrModel>

    @Query("SELECT * FROM surahmodel ORDER BY number")
    suspend fun getQuran(): List<SurahModel>

    @Query("SELECT * FROM surahmodel WHERE number = :surahIndex")
    suspend fun getSurah(surahIndex: Int): SurahModel

}