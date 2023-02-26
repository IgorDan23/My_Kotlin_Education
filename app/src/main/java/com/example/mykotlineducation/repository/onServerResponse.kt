package com.example.mykotlineducation.repository

import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO

fun interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}