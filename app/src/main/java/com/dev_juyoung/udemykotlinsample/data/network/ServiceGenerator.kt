package com.dev_juyoung.udemykotlinsample.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by juyounglee on 2018. 2. 9..
 */

private const val baseURL: String = "https://api.flickr.com/services/rest/"

private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

private val retrofit: Retrofit =
        Retrofit.Builder()
                .baseUrl(baseURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

fun <S> createService(serviceClass: Class<S>): S = retrofit.create(serviceClass)