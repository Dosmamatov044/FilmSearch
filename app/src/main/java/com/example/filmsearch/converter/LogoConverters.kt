package com.example.filmsearch.converter

import android.util.Log
import androidx.room.TypeConverter
import com.example.filmsearch.model.ExternalId
import com.example.filmsearch.model.Logo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object LogoConverters {

    private val gson = Gson()
    private val type: Type = object : TypeToken<Logo>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: Logo?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): Logo? =
        gson.fromJson(playlistItems, type)
}