package com.example.filmsearch.screens.later

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmsearch.R
import com.example.filmsearch.databinding.FragmentFavoriteBinding
import com.example.filmsearch.databinding.FragmentLaterBinding


class FragmentLater : Fragment() {
    lateinit var binding: FragmentLaterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaterBinding.inflate(layoutInflater)
        return binding.root
    }
}