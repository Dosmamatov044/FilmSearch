package com.example.filmsearch.converter

import androidx.room.TypeConverter
import com.example.filmsearch.model.Doc
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object DocConverter {

    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<Doc>>() {}.type

    @TypeConverter
    @JvmStatic
    fun listToString(items: MutableList<Doc>?): String? =
        gson.toJson(items, type)

    @TypeConverter
    @JvmStatic
    fun stringToList(items: String?): MutableList<Doc>? =
        gson.fromJson(items, type)

}