package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.ExternalId
import com.example.filmsearch.model.ReleaseYear
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object ExternalIdConverter {


    private val gson = Gson()
    private val type: Type = object : TypeToken<ExternalId>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: ExternalId?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): ExternalId? =
        gson.fromJson(playlistItems, type)
}