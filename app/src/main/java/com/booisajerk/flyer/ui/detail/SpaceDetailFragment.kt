package com.booisajerk.flyer.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.booisajerk.flyer.databinding.FragmentDetailBinding

class SpaceDetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setValues()
    }

    private fun setValues() {


        if (arguments?.let { SpaceDetailFragmentArgs.fromBundle(it) } != null) {
            binding.cameraNameValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).cameraName
            binding.cameraIdValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).cameraId.toString()
            binding.roverNameValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).roverName
            binding.cameraFullNameValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).cameraFullName
            binding.roverIdValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).roverId.toString()
            binding.roverLandingDateValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).roverLandingDate
            binding.roverLaunchDateValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).roverLaunchDate
            binding.roverStatusValue.text =
                SpaceDetailFragmentArgs.fromBundle(arguments!!).roverStatus
            binding.roverFullImage.load(SpaceDetailFragmentArgs.fromBundle(arguments!!).fullImage)
                }
            }


    companion object {
        fun newInstance() = SpaceDetailFragment()
    }
}