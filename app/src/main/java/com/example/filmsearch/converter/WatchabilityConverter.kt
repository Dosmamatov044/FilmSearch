package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Votes
import com.example.filmsearch.model.Watchability
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object WatchabilityConverter {

    private val gson = Gson()
    private val type: Type = object : TypeToken<Watchability>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: Watchability?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): Watchability? =
        gson.fromJson(playlistItems, type)
}