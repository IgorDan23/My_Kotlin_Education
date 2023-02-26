package com.example.mykotlineducation.repository

class RepositoryImp : Repository {


    override fun getWorldWeather(): List<Weather> {
        return getWorldCities()
    }

    override fun getRussianWeather(): List<Weather> {
        return getRussianCities()
    }


}