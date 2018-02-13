package com.dev_juyoung.udemykotlinsample.data.source.flickr

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoInfoData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.remote.FlickrRemoteDataSource

/**
 * Created by juyounglee on 2018. 2. 9..
 */

object FlickrRepository : FlickrDataSource {
    var cachedPhotoInfo: FlickrPhotoInfoData? = null

    private val remoteDataSource: FlickrRemoteDataSource by lazy {
        FlickrRemoteDataSource
    }

    override fun getResent(callback: FlickrDataSource.LoadFlickrPhotoCallback) {
        remoteDataSource.getResent(object : FlickrDataSource.LoadFlickrPhotoCallback {
            override fun onSuccess(data: FlickrPhotoData) {
                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }
        })
    }

    override fun getSearchPhotos(searchKeyword: String, requestPage: Int, callback: FlickrDataSource.LoadFlickrPhotoCallback) {
        remoteDataSource.getSearchPhotos(searchKeyword, requestPage, object : FlickrDataSource.LoadFlickrPhotoCallback {
            override fun onSuccess(data: FlickrPhotoData) {
                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }
        })
    }

    override fun getPhotoDetailInfo(photoId: String, callback: FlickrDataSource.LoadFlickrPhotoInfoCallback) {
        if (cachedPhotoInfo != null) cachedPhotoInfo = null

        remoteDataSource.getPhotoDetailInfo(photoId, object : FlickrDataSource.LoadFlickrPhotoInfoCallback {
            override fun onSuccess(data: FlickrPhotoInfoData) {
                // 상세데이터 조회 성공 후, Repository에 캐시.
                cachedPhotoInfo = data.takeIf { it.stat.contentEquals("ok") } ?: null

                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }
        })
    }
}