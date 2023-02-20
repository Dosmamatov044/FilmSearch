package com.example.filmsearch.screens.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsearch.App
import com.example.filmsearch.Constants
import com.example.filmsearch.model.Doc
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


     fun fetchMovieByName(name: String) {
        viewModelScope.launch {
            val data=  App.api?.fetchMovieByName(Constants.TOKEN,"name",name)




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


}