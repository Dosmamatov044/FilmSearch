package com.example.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import com.example.filmsearch.databinding.ActivityMainBinding
import com.example.filmsearch.screens.search.FilmSearchViewModel
   typealias tt=  FilmSearchViewModel
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel:tt by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        viewModel.filmsLiveData.observe(this){ data->

            data.forEach {
                Log.d("ololo",it.name)
            }




        }





    }
}