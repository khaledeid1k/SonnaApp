package com.sonna.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.giraffe.data.local.ContentDao
import com.giraffe.data.local.model.SurahModel

@Database(entities = [SurahModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContentDao(): ContentDao
}