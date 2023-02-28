package com.example.filmsearch


import com.example.filmsearch.model.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface FilmSearchApi {
 @Headers(
  "Content-Type: application/json;charset=utf-8",
  "Accept: application/json;charset=utf-8",
 )

 @GET("movie")
  suspend  fun fetchFilm(
  @Query("token") token: String,
  @Query("field") rating: String,
  @Query("search") search: String,
  @Query("field") year: String,
  @Query("search") search1: String,
  @Query("field") typeNumber: String,
  @Query("search") search2: Int,@Query("page")page:Int
  ):Response <Movies>

 @GET("movie")
 suspend  fun fetchMovieByName(
  @Query("token") token: String,
  @Query("field") nameField: String,
  @Query("search") nameSearch: String,
@Query("page") page:String
 ):Response <Movies>

 //field=rating.kp
// &search=7-10
// &field=year
// &search=2017-2020
// &field=typeNumber
// &search=2
// &sortField=year
// &sortType=1
// &sortField=votes.imdb
// &sortType=-1
// &token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06



}