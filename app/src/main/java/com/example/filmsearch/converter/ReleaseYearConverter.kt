package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.ReleaseYear
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object ReleaseYearConverter {


    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<ReleaseYear>>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: MutableList<ReleaseYear>?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): MutableList<ReleaseYear>? =
        gson.fromJson(playlistItems, type)
}