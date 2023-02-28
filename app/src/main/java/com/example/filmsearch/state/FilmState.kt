package com.example.filmsearch.state

sealed class FilmState<T> {

    data class Success<T>(val data:T):FilmState<T>()
    data class FAILED<T>(val message:String):FilmState<T>()
     class LOADING<T> :FilmState<T>()




    companion object{
        fun <T> loading()=LOADING<T>()
        fun <T> success(data:T)=Success<T>(data)
        fun <T> failed(message:String)=FAILED<T>(message)

    }
}