package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Poster
import com.example.filmsearch.model.Rating
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object RatingConverters {

    private val gson = Gson()
    private val type: Type = object : TypeToken<Rating>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: Rating?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): Rating? =
        gson.fromJson(playlistItems, type)
}