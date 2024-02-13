package com.sonna.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sonna.local.model.HadithBookDownloadedModel
import com.sonna.local.model.HadithModel
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

@Dao
interface ContentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(surahModel: SurahModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZekr(zekrModel: ZekrModel): Long

    @Query("SELECT * FROM zekrmodel")
    suspend fun getAzkar(): List<ZekrModel>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHadithBook(hadithBook : List<HadithModel>) : List<Long>
    @Query("SELECT * FROM hadith_book_model WHERE hadith LIKE :hadith AND number = :numberOfHadith")
    suspend fun getSingleHadith(hadith: String, numberOfHadith:Int): HadithModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDownloadedHadithBookName(hadithBookDownloadedModel: HadithBookDownloadedModel):Long
    @Query("SELECT EXISTS(SELECT * FROM hadith_book_names WHERE hadithBookName = :hadithBookName)")
    suspend fun isHadithBookDownloaded(hadithBookName: String): Boolean

}