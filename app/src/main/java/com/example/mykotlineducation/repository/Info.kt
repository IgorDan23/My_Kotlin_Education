package com.example.mykotlineducation.repository


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("lat")
    val lat: Number,
    @SerializedName("lon")
    val lon: Number,
    @SerializedName("url")
    val url: String
)