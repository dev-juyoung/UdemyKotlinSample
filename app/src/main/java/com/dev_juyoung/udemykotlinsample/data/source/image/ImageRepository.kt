package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 7..
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImages(size: Int, callback: ImageDataSource.LoadImagesCallback) {
        imageLocalData.loadImages(size, object : ImageDataSource.LoadImagesCallback {
            override fun onLoaded(images: List<ImageData>) {
                callback.onLoaded(images)
            }
        })
    }
}