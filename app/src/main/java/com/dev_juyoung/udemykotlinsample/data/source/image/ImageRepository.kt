package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData
import com.dev_juyoung.udemykotlinsample.data.source.image.local.ImageLocalDataSource
import com.dev_juyoung.udemykotlinsample.data.source.image.remote.ImageRemoteDataSource

/**
 * Created by juyounglee on 2018. 2. 7..
 */
object ImageRepository : ImageDataSource {

    private val IMAGE_LOCAL_DATA_SOURCE: ImageLocalDataSource by lazy {
        ImageLocalDataSource()
    }

    private val IMAGE_REMOTE_DATA_SOURCE: ImageRemoteDataSource by lazy {
        ImageRemoteDataSource()
    }

    override fun loadImages(size: Int, callback: ImageDataSource.LoadImagesCallback) {
        /* TODO: URL에서 불러오도록 변경.
        IMAGE_LOCAL_DATA_SOURCE.loadImages(size, object : ImageDataSource.LoadImagesCallback {
            override fun onLoaded(images: List<ImageData>) {
                callback.onLoaded(images)
            }
        })
        */

        IMAGE_REMOTE_DATA_SOURCE.loadImages(size, object : ImageDataSource.LoadImagesCallback {
            override fun onLoaded(images: List<ImageData>) {
                callback.onLoaded(images)
            }
        })
    }
}