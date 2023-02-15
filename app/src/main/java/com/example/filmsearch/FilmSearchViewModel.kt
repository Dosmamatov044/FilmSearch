package com.example.filmsearch

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.filmsearch.model.Doc
import kotlinx.coroutines.launch

class FilmSearchViewModel(application: Application): AndroidViewModel(application) {

    val films=MutableLiveData<List<Doc>> ()


    init {
      hasInternet()
    }





    fun hasInternet(){

        if (Network.checkConnectivity(getApplication())){

            fetchFilms()

        }else{

            App.getDao.getAllHuman().observeForever {
                films.value=it

            }

        }






    }


    @SuppressLint("SuspiciousIndentation")
    private fun fetchFilms() {


        viewModelScope.launch {



try {
    val data=  App.api?.fetchFilm(Constants.TOKEN,"rating.kp","7-10","year","1990-1999","typeNumber",2)
    data?.let {


        if (data.isSuccessful){

            films.value=data.body()?.docs

            Log.d("ololo", "Ок")

            App.getDao.addHuman(data.body()!!.docs)
        }else{

            Log.d("ololo", "Ошибка")

        }


    }
}catch (e:Exception){

    Log.d("ololo",e.message.toString())

}














        }






    }


}