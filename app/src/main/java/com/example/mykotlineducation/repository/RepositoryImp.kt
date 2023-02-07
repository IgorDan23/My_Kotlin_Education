package com.example.mykotlineducation.repository

class RepositoryImp : Repository {
    override fun getWorldWeatherFromServer(): List<Weather> {
        return getServerWorldCities()
    }
    override fun getRussianWeatherFromServer(): List<Weather> {
        return getServerRussianCities()
    }


    override fun getWorldWeatherFromLocalSt(): List<Weather> {
        return getWorldCities()
    }

    override fun getRussianWeatherFromLocalSt(): List<Weather> {
        return getRussianCities()
    }


}