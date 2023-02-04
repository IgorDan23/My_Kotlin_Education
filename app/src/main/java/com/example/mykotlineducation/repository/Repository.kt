package com.example.mykotlineducation.repository

interface Repository {
    fun getWeatherFromServer() : Weather
    fun getWeatherFromLocalSt() : Weather

}