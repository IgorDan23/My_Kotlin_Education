package com.example.mykotlineducation.repository

import com.example.mykotlineducation.viewmodel.HistoryViewModel

fun interface DetailsRepositoryForAll {
    fun getAllWeatherFromRepository(callbackWeather: HistoryViewModel.CallbackAllWeather)
}