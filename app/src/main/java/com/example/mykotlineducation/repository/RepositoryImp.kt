package com.example.mykotlineducation.repository

class RepositoryImp : Repository {
    override fun getWeatherFromServer(): List<Weather> {
        Thread.sleep(5000)
        return getWorldCities()
    }


    override fun getWorldWeatherFromLocalSt(): List<Weather> {
        Thread.sleep(1000)
        return getWorldCities()
    }

    override fun getRussianWeatherFromLocalSt(): List<Weather> {
        Thread.sleep(1000)
        return getRussianCities()
    }


}