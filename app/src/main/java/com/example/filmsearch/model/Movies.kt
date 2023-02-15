package com.example.filmsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Movies(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int,

)