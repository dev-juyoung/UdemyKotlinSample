package com.dev_juyoung.udemykotlinsample.data.source.image.remote

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData
import com.dev_juyoung.udemykotlinsample.data.source.image.ImageDataSource
import com.dev_juyoung.udemykotlinsample.util.random

/**
 * Created by juyounglee on 2018. 2. 8..
 */

class ImageRemoteDataSource : ImageDataSource {

    private val imageList = listOf(
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_01.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_02.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_03.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_04.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_05.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_06.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_07.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_08.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_09.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true"
    )

    override fun loadImages(size: Int, callback: ImageDataSource.LoadImagesCallback) {
        val data = mutableListOf<ImageData>()

        for (index in 1..size) {
            val randNumber = (1..10).random() + 1
            val imageName = String.format("sample_%02d", randNumber)
            val imageUrl = imageList[randNumber]
             data.add(ImageData(imageName, imageUrl))
        }

        callback.onLoaded(data)
    }
}