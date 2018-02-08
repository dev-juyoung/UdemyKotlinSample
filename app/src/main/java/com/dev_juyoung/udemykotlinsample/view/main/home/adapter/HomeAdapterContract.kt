package com.dev_juyoung.udemykotlinsample.view.main.home.adapter

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 8..
 */
interface HomeAdapterContract {
    interface View {
        fun updateView()
    }

    interface Model {
        fun addItems(images: List<ImageData>)
        fun updateItems(images: List<ImageData>)
    }
}