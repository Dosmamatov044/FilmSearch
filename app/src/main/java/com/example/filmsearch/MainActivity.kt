package com.example.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.filmsearch.databinding.ActivityMainBinding
import com.example.filmsearch.screens.search.FilmSearchViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel: FilmSearchViewModel by viewModels()
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