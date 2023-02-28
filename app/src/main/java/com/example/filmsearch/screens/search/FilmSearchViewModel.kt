package com.example.filmsearch.screens.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsearch.App
import com.example.filmsearch.Constants
import com.example.filmsearch.model.Doc
import com.example.filmsearch.model.Movies
import kotlinx.coroutines.launch

class FilmSearchViewModel: ViewModel() {

    val filmsLiveData=MutableLiveData<List<Doc>> ()









    init {
      //  fetchFilms()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun fetchFilms() {


        viewModelScope.launch {
          val data=  App.api?.fetchFilm(Constants.TOKEN,"rating.kp","7-10","year","2000-2001","typeNumber",1)


            try {
                if (data!!.isSuccessful){

                    filmsLiveData.value=data.body()?.docs


                }else{

                    Log.d("ololo", "else")//data.message())

                }


            }catch (e:Exception){

                Log.d("ololo","Exception")//data!!.message())

            }

        }

    }


     fun fetchMovieByName(name: String, page: Int = 1) {
        viewModelScope.launch {
            val data=  App.api?.fetchMovieByName(Constants.TOKEN,"name",name, page)




            try {
                if (data!!.isSuccessful){

                    filmsLiveData.value=data.body()?.docs
                    pages = data.body()?.pages

                }else{

                    Log.d("ololo", "else")//data.message())

                }


            }catch (e:Exception){

                Log.d("ololo","Exception")//data!!.message())

            }

        }

    }

companion object{
    var pages: Int? = 0
}
}