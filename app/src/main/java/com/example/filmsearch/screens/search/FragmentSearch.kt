package com.example.filmsearch.screens.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.filmsearch.R


import com.example.filmsearch.databinding.FragmentSearchBinding
import com.example.filmsearch.screens.result_search.FragmentResultSearch
import com.example.filmsearch.showToast
import com.example.filmsearch.state.FilmState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FragmentSearch : Fragment() {
    lateinit var binding: FragmentSearchBinding
    val viewModel: FilmSearchViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
//viewModel.fetchMovieByName(name)


          viewLifecycleOwner.lifecycleScope.launch {

              viewModel.fetchMovieByName(name).collect{

                  when(it){
                    is FilmState.LOADING->{

                        Log.d("tuuk","Загружаем")

                    }
                   is FilmState.Success->{
                       Log.d("tuuk",it.data)

                   }

                  is  FilmState.FAILED->{
                      Log.d("tuuk",it.message)


                  }

                  }



              }


          }





                }




                  // findNavController().navigate(R.id.fragmentResultSearch)}
}
            }



    }
