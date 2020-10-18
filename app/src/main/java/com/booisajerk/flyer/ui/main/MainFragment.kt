package com.booisajerk.flyer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.booisajerk.flyer.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.poster.load("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RLB_486265291EDR_F0481570RHAZ00323M_.JPG")

        binding.searchButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToResultFragment())
        }

        binding.podButton.setOnClickListener{
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToPODFragment())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}