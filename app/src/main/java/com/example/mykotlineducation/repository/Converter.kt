package com.example.mykotlineducation.repository

import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO

class Converter {
    fun weatherDTOtoWeather(weatherDTO: WeatherDTO, city: City): Weather =
        Weather(city, weatherDTO.fact.temperature, weatherDTO.fact.feelsLike,weatherDTO.fact.icon)


}