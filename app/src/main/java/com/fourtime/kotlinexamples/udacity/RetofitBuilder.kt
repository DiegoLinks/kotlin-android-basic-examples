package com.fourtime.kotlinexamples.udacity

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("https://www.udacity.com/public-api/v0/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(oKHttpClient)
                .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

    val oKHttpClient by lazy {
        OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .writeTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()
    }

    //Alternative form
//    fun apiInterfaceee(): ApiInterfaceee {
//        val oKHttpCliente = OkHttpClient.Builder()
//                .readTimeout(15, TimeUnit.SECONDS)
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .writeTimeout(15, TimeUnit.SECONDS)
//                .connectTimeout(15, TimeUnit.SECONDS)
//                .build()
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://www.udacity.com/public-api/v0/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                .client(oKHttpCliente)
//                .build()
//
//        return retrofit.create(ApiInterfaceee::class.java)
//    }
}