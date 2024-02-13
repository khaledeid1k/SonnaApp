package com.sonna.di

import android.content.Context
import androidx.room.Room
import com.sonna.database.AppDatabase
import com.sonna.local.CoreDao
import com.sonna.local.CoreLocalDataSource
import com.sonna.local.CoreLocalDataSourceImp
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
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideContentDao(appDataBase: AppDatabase): CoreDao {
        return appDataBase.getContentDao()
    }

    @Provides
    @Singleton
    fun provideContentLocalDataSource(coreDao: CoreDao): CoreLocalDataSource {
        return CoreLocalDataSourceImp(coreDao)
    }
}