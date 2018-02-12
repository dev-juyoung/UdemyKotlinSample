package com.dev_juyoung.udemykotlinsample.data.source.flickr.remote

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
        val service: FlickrService = createService(FlickrService::class.java)
        val request: Call<FlickrResentData> = service.getFlickrRecent(1, 30)
        request.enqueue(object : Callback<FlickrResentData> {
            override fun onResponse(call: Call<FlickrResentData>?, response: Response<FlickrResentData>?) {
                val succeed = response?.isSuccessful ?: false
                val data = response?.body()

                if (succeed) {
                    if (data != null) {
                        callback.onSuccess(data)
                    } else {
                        callback.onFailure("통신은 성공했으나, data가 없음.")
                    }
                } else {
                    callback.onFailure("Response Code 200 이 외의 코드로 인한 에러 처리.")
                }
            }

            override fun onFailure(call: Call<FlickrResentData>?, t: Throwable?) {
                callback.onFailure("Flickr 서버 장애 등의 문제로 인한 통신 실패.")
            }
        })
    }
}