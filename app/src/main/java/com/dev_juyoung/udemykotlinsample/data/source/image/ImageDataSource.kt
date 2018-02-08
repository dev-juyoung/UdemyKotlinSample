package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 7..
 */
interface ImageDataSource {

    interface LoadImagesCallback {
        fun onLoaded(images: List<ImageData>)
    }

    fun loadImages(size: Int, callback: LoadImagesCallback)
}