package com.sonna.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sonna.local.model.AyahModel

class Converters {

    @TypeConverter
    fun fromAyahs(ayahs: List<AyahModel>?): String {
        return Gson().toJson(ayahs)
    }

    @TypeConverter
    fun toAyahs(json: String): List<AyahModel>? {
        return try {
            Gson().fromJson<List<AyahModel>>(json)
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    private inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)
}
