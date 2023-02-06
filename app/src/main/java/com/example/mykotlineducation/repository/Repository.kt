package com.example.mykotlineducation.repository

interface Repository {
    fun getWeatherFromServer() : List<Weather>
    fun getWorldWeatherFromLocalSt(): List<Weather>
    fun getRussianWeatherFromLocalSt(): List<Weather>

}