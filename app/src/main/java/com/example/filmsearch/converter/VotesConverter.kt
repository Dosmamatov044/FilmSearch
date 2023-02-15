package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Poster
import com.example.filmsearch.model.Votes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object VotesConverter {

    private val gson = Gson()
    private val type: Type = object : TypeToken<Votes>() {}.type

    @TypeConverter
    @JvmStatic
    fun daysOfWeekToString(playlistItems: Votes?): String? =
        gson.toJson(playlistItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToDaysOfWeek(playlistItems: String?): Votes? =
        gson.fromJson(playlistItems, type)
}