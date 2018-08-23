package com.fourtime.kotlinexamples.udacity

import com.fourtime.kotlinexamples.udacity.models.CourseCatalog
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("courses")
    fun list(): Call<CourseCatalog>

}