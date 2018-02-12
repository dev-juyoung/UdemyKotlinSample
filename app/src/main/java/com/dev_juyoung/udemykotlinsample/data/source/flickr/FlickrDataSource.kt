package com.dev_juyoung.udemykotlinsample.data.source.flickr

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData

/**
 * Created by juyounglee on 2018. 2. 9..
 */
interface FlickrDataSource {

    interface LoadFlickrPhotoCallback {
        fun onSuccess(data: FlickrPhotoData)
        fun onFailure(message: String)
    }

    fun getResent(callback: LoadFlickrPhotoCallback)

    fun getSearchPhotos(searchKeyword: String, requestPage: Int, callback: LoadFlickrPhotoCallback)
}