package com.dev_juyoung.udemykotlinsample.data.network

import com.dev_juyoung.udemykotlinsample.BuildConfig
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrResentData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by juyounglee on 2018. 2. 9..
 */

interface FlickrService {
    @GET("?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    fun getFlickrRecent(
            @Query("api_key") apiKey: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<FlickrResentData>
}