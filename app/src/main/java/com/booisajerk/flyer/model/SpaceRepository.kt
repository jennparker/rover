package com.booisajerk.flyer.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SpaceRepository {

    fun getSpaceList(onResult: (isSuccess: Boolean, response: SpaceResponse?) -> Unit) {
        SpaceClient.instance.getSpace().enqueue(object : Callback<SpaceResponse> {
            override fun onResponse(call: Call<SpaceResponse>?, response: Response<SpaceResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<SpaceResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: SpaceRepository? = null
        fun getInstance() = INSTANCE
            ?: SpaceRepository().also {
                INSTANCE = it
            }
    }
}