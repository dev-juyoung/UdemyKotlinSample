package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData
import com.dev_juyoung.udemykotlinsample.util.random

/**
 * Created by juyounglee on 2018. 2. 7..
 */
class ImageLocalData : ImageDataSource {


    override fun loadImages(size: Int, callback: ImageDataSource.LoadImagesCallback) {
        val data = mutableListOf<ImageData>()

        for (index in 1..size) {
            val fileName = String.format("sample_%02d", (1..10).random() + 1)
            data.add(ImageData(fileName, fileName))
        }

        callback.onLoaded(data)
    }
}