package com.dev_juyoung.udemykotlinsample.data.source.flickr

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoInfoData

/**
 * Created by juyounglee on 2018. 2. 9..
 */
interface FlickrDataSource {

    interface LoadFlickrCallback <T>{
        fun onSuccess(t: T)
        fun onFailure(message: String)
    }

    fun getResent(callback: LoadFlickrCallback<FlickrPhotoData>)

    fun getSearchPhotos(searchKeyword: String, requestPage: Int, callback: LoadFlickrCallback<FlickrPhotoData>)

    fun getPhotoDetailInfo(photoId: String, callback: LoadFlickrCallback<FlickrPhotoInfoData>)
}