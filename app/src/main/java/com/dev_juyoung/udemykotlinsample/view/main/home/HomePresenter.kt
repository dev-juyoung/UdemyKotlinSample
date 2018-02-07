package com.dev_juyoung.udemykotlinsample.view.main.home

import android.os.AsyncTask
import com.dev_juyoung.udemykotlinsample.data.source.image.ImageRepository
import com.dev_juyoung.udemykotlinsample.util.random

/**
 * Created by juyounglee on 2018. 2. 6..
 */
class HomePresenter(
        val view: HomeContract.View,
        private val imageRepository: ImageRepository
) : HomeContract.Presenter {
    override fun loadImage() {
        ImageAsyncTask(view, imageRepository).execute()
    }

    class ImageAsyncTask(
            val view: HomeContract.View,
            val imageRepository: ImageRepository
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

            view.hideProgress()

            imageRepository.loadImageFileName {
                view.showImage(it)
            }
        }
    }
}