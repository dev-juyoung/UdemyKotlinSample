package com.dev_juyoung.udemykotlinsample.view.main.detail

/**
 * Created by juyounglee on 2018. 2. 12..
 */

interface PhotoDetailContract {
    interface View {
        fun updateItem(photoURL: String)
        fun updateToolbarItem(ownerImageURL: String, ownerName: String)
        fun onError(message: String)
        fun showWebPage(url: String)
    }

    interface Presenter {
        fun loadPhotoInfo(photoId: String)
    }
}