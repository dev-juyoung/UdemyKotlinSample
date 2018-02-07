package com.dev_juyoung.udemykotlinsample.data.source.image

import com.dev_juyoung.udemykotlinsample.util.random

/**
 * Created by juyounglee on 2018. 2. 7..
 */
class ImageLocalData : ImageDataSource {
    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("sample_%02d", (1..10).random()))
    }
}