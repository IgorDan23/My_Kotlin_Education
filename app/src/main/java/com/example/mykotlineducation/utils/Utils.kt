package com.example.mykotlineducation.utils

import com.example.mykotlineducation.domain.HistoryEntity
import com.example.mykotlineducation.repository.City
import com.example.mykotlineducation.repository.Weather

const val BUNDLE_WEATHER_KEY = "KEY"
const val API_KEY = "X-Yandex-API-Key"
const val YANDEX_DOMAIN = "https://api.weather.yandex.ru/"
const val WAVE = "myaction"
const val CITY_LAT = "lat"
const val CITY_LON = "lon"
const val YANDEX_ENDPOINT = "v2/informers?"
const val KEY_BUNDLE_WEATHERDTO="WeatherDTO"
const val KEY_BUNDLE_STATE_MESS="MES"

fun convertWeatherToEntity(weather: Weather):HistoryEntity{
    return HistoryEntity(0,weather.city.name,weather.temperature,weather.feelsLike,weather.icon)
}
fun convertHistoryEntityToWeather(historyEntityList:List<HistoryEntity>):List<Weather>{
    return historyEntityList.map {
        Weather(City(it.city,0.0,0.0),it.temperature,it.feelsLike,it.icon)
    }
}
