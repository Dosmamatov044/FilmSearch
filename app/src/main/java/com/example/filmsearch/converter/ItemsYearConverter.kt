package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Item
import com.example.filmsearch.model.ReleaseYear
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object ItemsYearConverter {


    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<Item>>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: MutableList<Item>?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): MutableList<Item>? =
        gson.fromJson(playlistItems, type)
}