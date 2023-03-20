package com.example.mykotlineducation.repository

import com.example.mykotlineducation.MyApp
import com.example.mykotlineducation.utils.*
import com.example.mykotlineducation.viewmodel.DetailsViewModel
import com.example.mykotlineducation.viewmodel.HistoryViewModel

class RoomRepositoryImp() : DetailsRepositoryForAll,DetailsRepositoryInter,DetailsRepositoryAddWeather {
    override fun getAllWeatherFromRepository(
        callbackWeather: HistoryViewModel.CallbackAllWeather
    ) {
        callbackWeather.onResponse(convertHistoryEntityToWeather(MyApp.getHistoryDao().getAll()))
    }
    override fun getWeatherFromRepository(
        city: City,
        callbackWeather: DetailsViewModel.CallbackWeather
    ) {
        val weatherList=convertHistoryEntityToWeather(MyApp.getHistoryDao().getHistoryForCity(city.name))
        callbackWeather.onResponse(weatherList.last())
    }

    override fun addWeather(weather: Weather) {
        MyApp.getHistoryDao().insert(convertWeatherToEntity(weather))
    }


}