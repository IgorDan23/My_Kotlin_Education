package com.example.mykotlineducation.repository

import com.example.mykotlineducation.viewmodel.DetailsViewModel

fun interface DetailsRepositoryInter {
    fun getWeatherFromRepository(city: City, callbackWeather: DetailsViewModel.CallbackWeather)
}