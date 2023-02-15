package com.example.filmsearch.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("movies")
data class Doc(
    val alternativeName: String?=null,
    val description: String?=null,


    val externalId: ExternalId?=null,
    @PrimaryKey()
    val id: Int,

    val logo: Logo?=null,
    val movieLength: Int?=null,
    val name: String?=null,
    val names: List<Name>?=null,

    val poster: Poster?=null,
    val rating: Rating?=null,
    val releaseYears: List<ReleaseYear>?=null,
    val shortDescription: String?=null,
    val type: String?=null,
    val votes: Votes?=null,
    val watchability: Watchability?=null,
    val year: Int?=null,

)