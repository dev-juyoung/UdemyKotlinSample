package com.dev_juyoung.udemykotlinsample.data.source.flickr.remote

import com.dev_juyoung.udemykotlinsample.data.network.FlickrService
import com.dev_juyoung.udemykotlinsample.data.network.createService
import com.dev_juyoung.udemykotlinsample.data.schme.FlickrPhotoData
import com.dev_juyoung.udemykotlinsample.data.source.flickr.FlickrDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by juyounglee on 2018. 2. 9..
 */

object FlickrRemoteDataSource : FlickrDataSource {
    override fun getResent(callback: FlickrDataSource.LoadFlickrPhotoCallback) {
        val service: FlickrService = createService(FlickrService::class.java)
        val request: Call<FlickrPhotoData> = service.getFlickrRecent(1, 30)
        request.enqueue(object : Callback<FlickrPhotoData> {
            override fun onResponse(call: Call<FlickrPhotoData>?, response: Response<FlickrPhotoData>?) {
                val succeed = response?.isSuccessful ?: false
                val data = response?.body()

                if (succeed) {
                    if (data != null) {
                        callback.onSuccess(data)
                    } else {
                        callback.onFailure("요청은 성공했으나, 응답 데이터가 없음.")
                    }
                } else {
                    callback.onFailure("요청은 성공했으나, 서버 개발자의 의도에 의한 Error 처리.")
                }
            }

            override fun onFailure(call: Call<FlickrPhotoData>?, t: Throwable?) {
                callback.onFailure("Flickr 서버 장애로 인해 서비스 불가.")
            }
        })
    }

    override fun getSearchPhotos(searchKeyword: String, requestPage: Int, callback: FlickrDataSource.LoadFlickrPhotoCallback) {
        val service: FlickrService = createService(FlickrService::class.java)
        val request: Call<FlickrPhotoData> = service.getFlickrSearchPhotos(searchKeyword, page = requestPage)

        request.enqueue(object : Callback<FlickrPhotoData> {
            override fun onResponse(call: Call<FlickrPhotoData>?, response: Response<FlickrPhotoData>?) {
                val succeed = response?.isSuccessful ?: false
                val data = response?.body()

                if (succeed) {
                    if (data != null) {
                        callback.onSuccess(data)
                    } else {
                        callback.onFailure("요청은 성공했으나, 응답 데이터가 없음.")
                    }
                } else {
                    callback.onFailure("요청은 성공했으나, 서버 개발자의 의도에 의한 Error 처리.")
                }
            }

            override fun onFailure(call: Call<FlickrPhotoData>?, t: Throwable?) {
                callback.onFailure("Flickr 서버 장애로 인해 서비스 불가.")
            }
        })
    }
}