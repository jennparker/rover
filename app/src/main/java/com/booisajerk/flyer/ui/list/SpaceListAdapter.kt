package com.booisajerk.flyer.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booisajerk.flyer.databinding.ViewSpaceListItemBinding
import com.booisajerk.flyer.model.Photo


class SpaceListAdapter(private val spaceListViewModel: SpaceListViewModel) : RecyclerView.Adapter<SpaceListViewHolder>() {
    private var spaceList: List<Photo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewSpaceListItemBinding.inflate(inflater, parent, false)
        Log.d(TAG, "creating viewHolder")
        return SpaceListViewHolder(binding, spaceListViewModel)
    }

    override fun getItemCount() = spaceList.size

    override fun onBindViewHolder(holder: SpaceListViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder called")
        holder.setUp(spaceList[position])

//        Glide.with(holder.itemView.context)
//            .load(spaceList[position].img_src)
//            .into(holder.itemView.image_thumbnail)
    }

    fun updateList(spaceList: List<Photo>) {
        Log.d(TAG, "updateList called. Setting list to: $spaceList")
        this.spaceList = spaceList
        notifyDataSetChanged()
    }

    companion object {
        const val TAG = "SpaceListAdapter"
    }
}