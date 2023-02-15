package com.example.filmsearch.screens.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.filmsearch.R
import com.example.filmsearch.databinding.FragmentResultBinding
import com.example.filmsearch.screens.search.FilmSearchViewModel


class FragmentResult : Fragment() {

    lateinit var binding: FragmentResultBinding
    val viewModel: FilmSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.filmsLiveData.observe(viewLifecycleOwner){
            binding.tvTitleMovie.text = viewModel.filmsLiveData.value.toString()
        }
    }
}