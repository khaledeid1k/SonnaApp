package com.sonna.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.sonna.data.local.model.SurahModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContentDao(): com.sonna.data.local.ContentDao
}