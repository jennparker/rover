package com.booisajerk.flyer.ui.list

import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.booisajerk.flyer.BR
import com.booisajerk.flyer.R
import com.booisajerk.flyer.model.Photo
import kotlinx.android.synthetic.main.view_space_list_item.view.*

class SpaceListViewHolder constructor(
    private val binding: ViewDataBinding,
    private val spaceListViewModel: SpaceListViewModel
) : RecyclerView.ViewHolder(binding.root) {


    fun setUp(photoData: Photo) {
        Log.d(TAG, "setUp called. For this photo: $photoData")
        binding.setVariable(BR.photoData, photoData)
        binding.executePendingBindings()

        itemView.image_thumbnail.load(photoData.img_src)

        itemView.setOnClickListener {

            val bundle = Bundle()
            bundle.apply {
                putInt("camera_id", photoData.camera.id)
                putString("camera_name", photoData.camera.name)
                putString("camera_full_name", photoData.camera.full_name)
                putString("full_image", photoData.img_src)
                putInt("rover_id", photoData.rover.id)
                putString("rover_name", photoData.rover.name)
                putString("rover_landing_date", photoData.rover.landing_date)
                putString("rover_launch_date", photoData.rover.launch_date)
                putString("rover_status", photoData.rover.status)
            }

            itemView.findNavController()
                .navigate(R.id.action_resultFragment_to_spaceDetailFragment, bundle)
        }

    }

    companion object {
        private const val TAG = "SpaceListViewHolder"
    }
}