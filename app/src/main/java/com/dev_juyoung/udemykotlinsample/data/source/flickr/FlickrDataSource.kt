package com.dev_juyoung.udemykotlinsample.data.source.flickr

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData

/**
 * Created by juyounglee on 2018. 2. 9..
 */
interface FlickrDataSource {

    interface LoadRecentCallback {
        fun onSuccess(data: FlickrPhotoData)
        fun onFailure(errorMessage: String)
    }

    fun getResent(callback: LoadRecentCallback)
}