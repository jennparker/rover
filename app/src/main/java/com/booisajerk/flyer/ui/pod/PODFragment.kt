package com.booisajerk.flyer.ui.pod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booisajerk.flyer.databinding.FragmentPodBinding

class PODFragment : Fragment() {
    private lateinit var binding: FragmentPodBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPodBinding.inflate(inflater, container, false)

        return binding.root
    }
}