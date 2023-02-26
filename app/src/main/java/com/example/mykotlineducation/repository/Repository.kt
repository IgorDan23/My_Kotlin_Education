package com.example.mykotlineducation.repository

interface Repository {
    fun getWorldWeather(): List<Weather>
    fun getRussianWeather(): List<Weather>

}