package com.dev_juyoung.udemykotlinsample.view.main.detail

import android.util.Log
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository

/**
 * Created by juyounglee on 2018. 2. 12..
 */
class PhotoDetailPresenter(
        val view: PhotoDetailContract.View,
        private val flickrRepository: FlickrRepository
) : PhotoDetailContract.Presenter {
    override fun loadPhotoInfo(photoId: String) {
        Log.d("PhotoDetailPresenter", "photoId: $photoId")
    }
}