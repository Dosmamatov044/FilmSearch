package com.example.filmsearch.screens.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsearch.App
import com.example.filmsearch.Constants
import com.example.filmsearch.model.Doc
import com.example.filmsearch.state.FilmState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class FilmSearchViewModel : ViewModel() {

    val filmsLiveData = MutableLiveData<List<Doc>>()

    init {
        //  fetchFilms()
    }





    fun fetchMovieByName(name: String)= callbackFlow<FilmState<String>> {


        viewModelScope.launch {
            val data = App.api?.fetchMovieByName(Constants.TOKEN, "name", name, "3")




            delay(1000)


              trySendBlocking(FilmState.loading())




            try {
                if (data!!.isSuccessful) {

                    filmsLiveData.value = data.body()?.docs
               trySendBlocking(FilmState.success( "Ok"))

                } else {
                 trySendBlocking(FilmState.failed("Error"))
                    Log.d("ololo", "else")//data.message())


                }

if (data.code()==0){

    Log.d("ololo","fail")

}





            } catch (e: Exception) {
                trySendBlocking(FilmState.failed("Error"))
                Log.d("ololo", "Exception")//data!!.message())


            }finally {
                if (data?.code()==0){

                    Log.d("ololo","fail")

                }

            }

        }



        awaitClose {}

    }.flowOn(Dispatchers.IO)


}



