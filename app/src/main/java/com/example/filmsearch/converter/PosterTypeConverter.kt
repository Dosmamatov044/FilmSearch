package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Logo
import com.example.filmsearch.model.Poster
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object PosterTypeConverter {

    private val gson = Gson()
    private val type: Type = object : TypeToken<Poster>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: Poster?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): Poster? =
        gson.fromJson(playlistItems, type)
}