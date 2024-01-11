package com.sonna.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sonna.data.local.model.SurahModel
import com.sonna.local.ContentDao

@Database(entities = [SurahModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContentDao(): ContentDao
}