package com.dev_juyoung.udemykotlinsample.data.source.image

/**
 * Created by juyounglee on 2018. 2. 7..
 */
interface ImageDataSource {
    fun loadImageFileName(fileName: (String) -> Unit)
}