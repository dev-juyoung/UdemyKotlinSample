package com.dev_juyoung.udemykotlinsample.view.main.home

import android.os.AsyncTask
import android.util.Log
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrResentData
import com.dev_juyoung.udemykotlinsample.data.schme.ImageData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrDataSource
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrRepository
import com.dev_juyoung.udemykotlinsample.data.source.image.ImageDataSource
import com.dev_juyoung.udemykotlinsample.data.source.image.ImageRepository
import com.dev_juyoung.udemykotlinsample.util.random
import com.dev_juyoung.udemykotlinsample.view.main.home.adapter.HomeAdapterContract

/**
 * Created by juyounglee on 2018. 2. 6..
 */
class HomePresenter(
        val view: HomeContract.View,
        private val imageRepository: ImageRepository,
        private val adapterView: HomeAdapterContract.View,
        private val adapterModel: HomeAdapterContract.Model,
        private val flickrRepository: FlickrRepository
) : HomeContract.Presenter {

    override fun testFlickr() {
        flickrRepository.getResent(object : FlickrDataSource.LoadRecentCallback {
            override fun onSuccess(data: FlickrResentData) {
                Log.d("PRESENTER", "data: $data")
            }

            override fun onFailure(errorMessage: String) {
                Log.e("PRESENTER", "error: $errorMessage")
            }
        })
    }

    override fun loadImage() {
        ImageAsyncTask(view, imageRepository, adapterView, adapterModel).execute()
    }

    class ImageAsyncTask(
            val view: HomeContract.View,
            private val imageRepository: ImageRepository,
            private val adapterView: HomeAdapterContract.View,
            private val adapterModel: HomeAdapterContract.Model
    ) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            Thread.sleep(1000)
        }

        override fun onPreExecute() {
            super.onPreExecute()
            view.showProgress()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            imageRepository.loadImages(10, object : ImageDataSource.LoadImagesCallback {
                override fun onLoaded(images: List<ImageData>) {
                    // adapterModel.addItems(images)
                    adapterModel.updateItems(images)
                    adapterView.updateView()
                    view.hideProgress()
                }
            })
        }
    }
}