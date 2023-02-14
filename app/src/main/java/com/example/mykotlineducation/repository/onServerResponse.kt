package com.example.mykotlineducation.repository

fun interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}