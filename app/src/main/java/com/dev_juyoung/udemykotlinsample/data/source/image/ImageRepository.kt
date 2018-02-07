package com.dev_juyoung.udemykotlinsample.data.source.image

/**
 * Created by juyounglee on 2018. 2. 7..
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(fileName: (String) -> Unit) {
        imageLocalData.loadImageFileName(fileName)
    }
}