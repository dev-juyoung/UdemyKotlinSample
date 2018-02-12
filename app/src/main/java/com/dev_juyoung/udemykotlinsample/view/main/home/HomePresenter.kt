package com.dev_juyoung.udemykotlinsample.view.main.home

import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrDataSource
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository
import com.dev_juyoung.udemykotlinsample.view.main.home.adapter.HomeAdapterContract

/**
 * Created by juyounglee on 2018. 2. 6..
 */
class HomePresenter(
        val view: HomeContract.View,
        private val flickrRepository: FlickrRepository,
        private val adapterView: HomeAdapterContract.View,
        private val adapterModel: HomeAdapterContract.Model
) : HomeContract.Presenter {
    var isLoading: Boolean = false
    var requestPage: Int = 0

    override fun loadFlickrPhotos(isUpdate: Boolean) {
        isLoading = true
        view.showProgress()

        flickrRepository.getSearchPhotos("night view", requestPage, object : FlickrDataSource.LoadFlickrPhotoCallback {
            override fun onSuccess(data: FlickrPhotoData) {
                view.hideProgress()
                isLoading = false

                if (data.stat.contentEquals("ok")) {
                    if (!isUpdate) {
                        adapterModel.addItems(data.photos.photo)
                    } else {
                        adapterModel.updateItems(data.photos.photo)
                    }

                    adapterView.updateView()

                    requestPage++
                } else {
                    view.showMessage("stat: ${data.stat}, message: ${data.message}")
                }
            }

            override fun onFailure(message: String) {
                view.hideProgress()
                view.showMessage(message)
                isLoading = false
            }
        })
    }
}