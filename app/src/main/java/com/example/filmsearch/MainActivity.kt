package com.example.filmsearch

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.filmsearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel:FilmSearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.films.observe(this){data->


            data.forEach {

                binding.txt.append(it.name+ "   ")
            }





        }







    }
}