package com.sonna.local.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SonnaPreferences(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = "SonnaDataStore"
    )

    private val selectedHadithBook = stringPreferencesKey("hadith_book")

    suspend fun saveSelectedHadithBook(hadithBook: String) {
        context.dataStore.edit { preferences ->
            preferences[selectedHadithBook] = hadithBook

        }
    }

    suspend fun readSelectedHadithBook(): String {
        return context.dataStore.data.map { preferences ->
            preferences[selectedHadithBook] ?: "darimi"
        }.first()
    }


}