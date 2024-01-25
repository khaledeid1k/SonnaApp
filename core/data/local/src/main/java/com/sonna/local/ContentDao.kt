package com.sonna.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sonna.local.model.SurahModel
import com.sonna.local.model.ZekrModel

@Dao
interface ContentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(surahModel: SurahModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZekr(zekrModel: ZekrModel): Long

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