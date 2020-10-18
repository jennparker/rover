package com.booisajerk.flyer.model

import com.booisajerk.flyer.utils.Keys.Companion.NASA_API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceService {

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getSpace(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") key: String = NASA_API_KEY
    )
            : Call<SpaceResponse>

}

//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
