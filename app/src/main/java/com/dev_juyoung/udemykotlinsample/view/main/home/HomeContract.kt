package com.dev_juyoung.udemykotlinsample.view.main.home

import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 6..
 */
interface HomeContract {
    interface View {
        fun hideProgress()
        fun showProgress()

    }

    interface Presenter {
        fun loadImage()
        fun testFlickr()
    }
}