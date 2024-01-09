package com.sonna.di

import android.content.Context
import androidx.room.Room
import com.giraffe.data.local.ContentDao
import com.giraffe.data.local.ContentLocalDataSource
import com.giraffe.data.local.ContentLocalDataSourceImp
import com.sonna.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "sonna_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideContentDao(appDataBase: AppDatabase): ContentDao {
        return appDataBase.getContentDao()
    }

    @Provides
    @Singleton
    fun provideContentLocalDataSource(contentDao: ContentDao): ContentLocalDataSource {
        return ContentLocalDataSourceImp(contentDao)
    }
}