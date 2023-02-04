package com.example.mykotlineducation.repository

class RepositoryImp : Repository {
    override fun getWeatherFromServer(): Weather {
        Thread.sleep(5000)
        return Weather()
    }

    override fun getWeatherFromLocalSt(): Weather {
        Thread.sleep(2000)
        return Weather()
    }
}