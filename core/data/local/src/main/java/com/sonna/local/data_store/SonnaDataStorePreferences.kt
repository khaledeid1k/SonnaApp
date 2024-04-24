package com.sonna.local.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sonna.domain.entity.hadith.HadithBookNames
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SonnaDataStorePreferences(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = "SonnaDataStore"
    )

    private val selectedHadithBookName = stringPreferencesKey("hadith_book_name")

    suspend fun saveSelectedHadithBookName(hadithBookName: String) {
        context.dataStore.edit { preferences ->
            preferences[selectedHadithBookName] = hadithBookName
        }
    }
    suspend fun readSelectedHadithBookName(): String {
        return context.dataStore.data.map { preferences ->
            preferences[selectedHadithBookName] ?: HadithBookNames.Darimi.name
        }.first()
    }

}