package com.sonna.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sonna.local.model.SurahModel
import com.sonna.local.ContentDao
import com.sonna.local.model.HadithBookDownloadedModel
import com.sonna.local.model.HadithModel
import com.sonna.local.model.ZekrModel

@Database(entities = [SurahModel::class, ZekrModel::class,HadithModel::class, HadithBookDownloadedModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContentDao(): ContentDao
}