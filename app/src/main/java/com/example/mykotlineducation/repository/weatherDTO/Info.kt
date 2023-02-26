package com.example.mykotlineducation.repository.weatherDTO


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info(
    @SerializedName("lat")
    val lat: Number,
    @SerializedName("lon")
    val lon: Number,
    @SerializedName("url")
    val url: String
): Parcelable