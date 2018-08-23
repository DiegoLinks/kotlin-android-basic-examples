package com.fourtime.kotlinexamples.udacity.models

import com.google.gson.annotations.SerializedName

class CourseCatalog(

        @SerializedName("courses")
        val courses : List<Course>
)