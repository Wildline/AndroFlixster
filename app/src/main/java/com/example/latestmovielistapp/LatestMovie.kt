package com.example.latestmovielistapp

import com.google.gson.annotations.SerializedName

class LatestMovie {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null

    //TODO bookImageUrl
    @SerializedName("poster_path")
    var posterPath: String? = null


    //TODO description
    @SerializedName("description")
    var description: String? = null

}