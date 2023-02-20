package com.example.filmsearch.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.filmsearch.R
import com.example.filmsearch.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ibSearch.setOnClickListener { findNavController().navigate(R.id.fragmentSearch) }
        binding.ibFavorite.setOnClickListener { findNavController().navigate(R.id.fragmentFavorite) }
        binding.ibLater.setOnClickListener { findNavController().navigate(R.id.fragmentLater) }
        binding.ibWatched.setOnClickListener { findNavController().navigate(R.id.fragmentWatched) }
    }
}