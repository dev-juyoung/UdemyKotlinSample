package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 7..
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    private val imageRemoteData: ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImages(size: Int, callback: ImageDataSource.LoadImagesCallback) {
        /* TODO: URL에서 불러오도록 변경.
        imageLocalData.loadImages(size, object : ImageDataSource.LoadImagesCallback {
            override fun onLoaded(images: List<ImageData>) {
                callback.onLoaded(images)
            }
        })
        */

        imageRemoteData.loadImages(size, object : ImageDataSource.LoadImagesCallback {
            override fun onLoaded(images: List<ImageData>) {
                callback.onLoaded(images)
            }
        })
    }
}