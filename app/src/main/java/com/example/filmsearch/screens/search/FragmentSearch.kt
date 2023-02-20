package com.example.filmsearch.screens.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.filmsearch.R


import com.example.filmsearch.databinding.FragmentSearchBinding
import com.example.filmsearch.screens.result_search.FragmentResultSearch
import com.example.filmsearch.showToast


class FragmentSearch : Fragment() {
    lateinit var binding: FragmentSearchBinding
    val viewModel: FilmSearchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            if (binding.etInputName.text.isEmpty()){
                activity?.showToast("Введите название!")
            }
            else{
                val name = binding.etInputName.text.toString()
                viewModel.fetchMovieByName(name = name)


                   findNavController().navigate(R.id.fragmentResultSearch)}
}
            }



    }
