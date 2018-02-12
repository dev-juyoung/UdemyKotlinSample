package com.dev_juyoung.udemykotlinsample.view.main.home

/**
 * Created by juyounglee on 2018. 2. 6..
 */
interface HomeContract {
    interface View {
        fun hideProgress()
        fun showProgress()
        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadFlickrPhotos(isUpdate: Boolean = false)
    }
}