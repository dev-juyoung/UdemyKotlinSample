package com.dev_juyoung.udemykotlinsample.view.main.detail

/**
 * Created by juyounglee on 2018. 2. 12..
 */

interface PhotoDetailContract {
    interface View {

    }

    interface Presenter {
        fun loadPhotoInfo(photoId: String)
    }
}