package com.dev_juyoung.udemykotlinsample.data.source.flickr

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrResentData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.remote.FlickrRemoteDataSource

/**
 * Created by juyounglee on 2018. 2. 9..
 */

object FlickrRepository : FlickrDataSource {
    private val remoteDataSource: FlickrRemoteDataSource by lazy {
        FlickrRemoteDataSource
    }

    override fun getResent(callback: FlickrDataSource.LoadRecentCallback) {
        remoteDataSource.getResent(object : FlickrDataSource.LoadRecentCallback {
            override fun onSuccess(data: FlickrResentData) {
                callback.onSuccess(data)
            }

            override fun onFailure(errorMessage: String) {
                callback.onFailure(errorMessage)
            }
        })
    }
}