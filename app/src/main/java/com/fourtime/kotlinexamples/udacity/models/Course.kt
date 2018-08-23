package com.fourtime.kotlinexamples.udacity.models

import com.google.gson.annotations.SerializedName

class Course(

        @SerializedName("title")
        val title : String = "",
        @SerializedName("subtitle")
        val subtitle : String = "",
        @SerializedName("expected_learning")
        val expected_learning : String = "",
        @SerializedName("image")
        val image : String = ""
)