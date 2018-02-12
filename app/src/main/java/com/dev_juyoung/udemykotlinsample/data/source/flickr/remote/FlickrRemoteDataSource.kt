package com.dev_juyoung.udemykotlinsample.data.source.flickr.remote

import android.util.Log
import com.dev_juyoung.udemykotlinsample.BuildConfig
import com.dev_juyoung.udemykotlinsample.data.network.FlickrService
import com.dev_juyoung.udemykotlinsample.data.network.createService
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrResentData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by juyounglee on 2018. 2. 9..
 */

object FlickrRemoteDataSource : FlickrDataSource {
    override fun getResent(callback: FlickrDataSource.LoadRecentCallback) {
        val flickrService: FlickrService = createService(FlickrService::class.java)
        val request: Call<FlickrResentData> = flickrService.getFlickrRecent(BuildConfig.FLICKR_API_KEY, 1, 30)
        request.enqueue(object : Callback<FlickrResentData> {
            override fun onResponse(call: Call<FlickrResentData>?, response: Response<FlickrResentData>?) {
                val succeed = response?.isSuccessful ?: false
                val data = response?.body()

                if (succeed) {
                    if (data != null && data.stat.contentEquals("ok")) {
                        callback.onSuccess(data)
                    } else {
                        callback.onFailure("데이터 없음.")
                    }
                } else {
                    callback.onFailure("status 200 아닌 에러.")
                }
            }

            override fun onFailure(call: Call<FlickrResentData>?, t: Throwable?) {
                callback.onFailure("flickr 서버 장애(?)")
            }
        })
    }
}