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

    @Query("SELECT * FROM surahmodel ORDER BY number")
    suspend fun getQuran(): List<SurahModel>

    /*@Query("SELECT * FROM cart_table")
    fun getCartItems(): Flow<List<CartItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItem): Long

    @Delete
    suspend fun deleteCartItem(cartItem: CartItem): Int

    @Query("DELETE FROM cart_table")
    suspend fun deleteAllCartItems()

    @Update
    suspend fun updateCartItem(cartItem: CartItem)*/
}