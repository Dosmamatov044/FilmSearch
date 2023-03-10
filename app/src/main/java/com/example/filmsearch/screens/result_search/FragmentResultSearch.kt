package com.example.filmsearch.screens.result_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsearch.databinding.FragmentResultSearchBinding
import com.example.filmsearch.model.Doc

import com.example.filmsearch.screens.search.FilmSearchViewModel


class FragmentResultSearch : Fragment() {

    lateinit var binding: FragmentResultSearchBinding
    val viewModel: FilmSearchViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ResultSearchAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultSearchBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        init()
    }
    private fun init() {

        recyclerView = binding.rvResultSearch
        adapter = ResultSearchAdapter()//this::onItemClick)
        recyclerView.adapter = adapter
        viewModel.filmsLiveData.observe(viewLifecycleOwner){
            adapter.resultList = it
            //  binding.tvTitleMovie.text = viewModel.filmsLiveData.value.toString()
        }
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}