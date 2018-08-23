package com.fourtime.kotlinexamples.udacity

import com.fourtime.kotlinexamples.udacity.models.CourseCatalog
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

//ALternative form (use Deferred)
interface ApiInterfaceee {

    @GET("courses")
    fun list(): Deferred<CourseCatalog>
}