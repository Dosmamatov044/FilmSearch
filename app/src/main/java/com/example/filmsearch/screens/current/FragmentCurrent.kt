package com.example.filmsearch.screens.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmsearch.R
import com.example.filmsearch.databinding.FragmentCurrentBinding


class FragmentCurrent : Fragment() {
    lateinit var binding: FragmentCurrentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentBinding.inflate(layoutInflater)
        return binding.root


    }
}