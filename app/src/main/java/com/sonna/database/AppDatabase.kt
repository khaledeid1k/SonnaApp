package com.sonna.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sonna.local.model.SurahModel
import com.sonna.local.CoreDao
import com.sonna.local.model.ZekrModel

@Database(entities = [SurahModel::class, ZekrModel::class], version = 2,exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContentDao(): CoreDao
}