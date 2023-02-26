package com.example.mykotlineducation.repository

import androidx.lifecycle.MutableLiveData
import com.example.mykotlineducation.BuildConfig
import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO
import com.example.mykotlineducation.utils.*
import com.example.mykotlineducation.viewmodel.AppState
import com.example.mykotlineducation.viewmodel.DetailsViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

class Retrofit2Repository() : DetailsRepositoryInter {
    lateinit var weatherAPI: WeatherAPI

    override fun getWeatherFromRepository(
        city: City,
        callbackWeather: DetailsViewModel.CallbackWeather
    ) {
        weatherAPI = Retrofit.Builder().apply {
            baseUrl(YANDEX_DOMAIN)
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build().create(WeatherAPI::class.java)
        //weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY,city.lat,city.lon).execute() //можно так
        weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY, city.lat, city.lon)
            .enqueue(object : retrofit2.Callback<WeatherDTO> {
                override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callbackWeather.onResponse(Converter().weatherDTOtoWeather(it, city))
                        }
                    }
                }

                override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }
}