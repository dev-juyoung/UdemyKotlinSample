package com.dev_juyoung.udemykotlinsample.view.main.home

/**
 * Created by juyounglee on 2018. 2. 6..
 */
interface HomeContract {
    interface View {
        fun showImage(imageName: String)
        fun hideProgress()
        fun showProgress()

    }

    interface Presenter {
        fun loadImage()
    }
}