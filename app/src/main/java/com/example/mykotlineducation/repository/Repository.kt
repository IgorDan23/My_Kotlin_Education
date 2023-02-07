package com.example.mykotlineducation.repository

interface Repository {
    fun getWorldWeatherFromServer() : List<Weather>
    fun getRussianWeatherFromServer() : List<Weather>
    fun getWorldWeatherFromLocalSt(): List<Weather>
    fun getRussianWeatherFromLocalSt(): List<Weather>

}