package com.dev_juyoung.udemykotlinsample.view.main.home

import android.os.AsyncTask
import com.dev_juyoung.udemykotlinsample.util.random

/**
 * Created by juyounglee on 2018. 2. 6..
 */
class HomePresenter(val view: HomeContract.View) : HomeContract.Presenter {
    override fun loadImage() {
        ImageAsyncTask(view).execute()
    }

    class ImageAsyncTask(val view: HomeContract.View) : AsyncTask<Unit, Unit, String>() {
        override fun doInBackground(vararg params: Unit?): String {
            Thread.sleep(1000)

            return String.format("sample_%02d", (1..10).random())
        }

        override fun onPreExecute() {
            super.onPreExecute()

            view.showProgress()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            view.hideProgress()
            result?.let {
                view.showImage(it)
            }
        }
    }
}