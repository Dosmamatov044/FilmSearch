package com.example.filmsearch.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmsearch.R
import com.example.filmsearch.databinding.FragmentFavoriteBinding


class FragmentFavorite : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }


}