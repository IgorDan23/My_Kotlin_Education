package com.example.mykotlineducation.repository

import com.example.mykotlineducation.BuildConfig
import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO
import com.example.mykotlineducation.utils.*
import com.example.mykotlineducation.viewmodel.DetailsViewModel
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class OkHttpRepository:DetailsRepositoryInter {

    override fun getWeatherFromRepository(city: City, callbackWeather: DetailsViewModel.CallbackWeather) {
        val client = OkHttpClient()
        val builder = Request.Builder()
        builder.addHeader(API_KEY, BuildConfig.WEATHER_API_KEY)
        builder.url("$YANDEX_DOMAIN$YANDEX_ENDPOINT$CITY_LAT=${city.lat}&$CITY_LON=${city.lon}")
        val request= builder.build()
        Thread{
            val call = client.newCall(request)
            val response= call.execute()
            if(response.isSuccessful) {
                val weatherDTO: WeatherDTO = Gson().fromJson(response.body!!.string(), WeatherDTO::class.java)
                val weather = Converter().weatherDTOtoWeather(weatherDTO,city)
                callbackWeather.onResponse(weather)
            }

        }.start()

    }
}