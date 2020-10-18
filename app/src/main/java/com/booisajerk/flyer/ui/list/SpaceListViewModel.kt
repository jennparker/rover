package com.booisajerk.flyer.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.booisajerk.flyer.BaseViewModel
import com.booisajerk.flyer.model.Photo
import com.booisajerk.flyer.model.SpaceRepository

class SpaceListViewModel : BaseViewModel() {

    val spaceListLive = MutableLiveData<List<Photo>>()

    fun fetchSpaceList() {
        Log.d(TAG, "fetching space list")
        dataLoading.value = true
        SpaceRepository.getInstance().getSpaceList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                Log.d(TAG, "fetching was a success!")
                spaceListLive.value = response?.photos
                empty.value = false
            } else {
                Log.d(TAG, "fetching failed!")
                empty.value = true
            }
        }
    }

    companion object {
        private const val TAG = "SpaceListViewModel"
    }
}