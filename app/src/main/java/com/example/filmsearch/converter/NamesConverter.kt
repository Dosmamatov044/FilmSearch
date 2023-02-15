package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Doc
import com.example.filmsearch.model.Name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object NamesConverter {

    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<Name>>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: MutableList<Name>?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): MutableList<Name>? =
        gson.fromJson(playlistItems, type)
}