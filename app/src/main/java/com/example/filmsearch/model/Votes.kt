package com.example.filmsearch.model

data class Votes(
    val _id: String,
    val await: Int,
    val filmCritics: Int,
    val imdb: Int,
    val kp: Int,
    val russianFilmCritics: Int
)