package com.dev_juyoung.udemykotlinsample.data.network

import com.dev_juyoung.udemykotlinsample.BuildConfig
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoInfoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by juyounglee on 2018. 2. 9..
 */

interface FlickrService {
    @GET("?method=flickr.photos.getRecent")
    fun getFlickrRecent(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int,
            @Query("api_key") apiKey: String = BuildConfig.FLICKR_API_KEY,
            @Query("format") outputFormat: String = "json",
            @Query("nojsoncallback") noJsonCallback: Int = 1
    ): Call<FlickrPhotoData>

    @GET("?method=flickr.photos.search")
    fun getFlickrSearchPhotos(
            @Query("text") searchKeyword: String,
            @Query("safe_search") safeSearch: Int = 1,
            @Query("page") page: Int = 1,
            @Query("per_page") perPage: Int = 30,
            @Query("api_key") apiKey: String = BuildConfig.FLICKR_API_KEY,
            @Query("format") outputFormat: String = "json",
            @Query("nojsoncallback") noJsonCallback: Int = 1
    ) : Call<FlickrPhotoData>

    @GET("?method=flickr.photos.getInfo")
    fun getFlickrPhotoDetailInfo(
            @Query("photo_id") photoId: String,
            @Query("api_key") apiKey: String = BuildConfig.FLICKR_API_KEY,
            @Query("format") outputFormat: String = "json",
            @Query("nojsoncallback") noJsonCallback: Int = 1
    ) : Call<FlickrPhotoInfoData>
}