package com.sonna.di

import android.content.Context
import androidx.room.Room
import com.sonna.database.AppDatabase
import com.sonna.local.ContentDao
import com.sonna.local.ContentLocalDataSource
import com.sonna.local.ContentLocalDataSourceImp
import com.sonna.local.data_store.SonnaPreferences
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
    fun provideContentLocalDataSource(contentDao: ContentDao,sonnaPreferences:SonnaPreferences): ContentLocalDataSource {
        return ContentLocalDataSourceImp(contentDao,sonnaPreferences)
    }

    @Provides
    @Singleton
    fun provideDataStore(context: Context):SonnaPreferences{
        return SonnaPreferences(context)
    }
}