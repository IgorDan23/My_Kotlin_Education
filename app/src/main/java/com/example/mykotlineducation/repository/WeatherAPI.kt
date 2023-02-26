package com.example.mykotlineducation.repository

import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO
import com.example.mykotlineducation.utils.API_KEY
import com.example.mykotlineducation.utils.CITY_LAT
import com.example.mykotlineducation.utils.CITY_LON
import com.example.mykotlineducation.utils.YANDEX_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherAPI {
    @GET(YANDEX_ENDPOINT)
    fun getWeather(
        @Header(API_KEY) apikey: String,
        @Query(CITY_LAT) lat: Double,
        @Query(CITY_LON) lon: Double
    ): Call<WeatherDTO>
}