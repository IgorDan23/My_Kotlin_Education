package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlineducation.repository.RepositoryImp
import kotlin.properties.Delegates


class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImp = RepositoryImp()
) : ViewModel() {
    private var isRussian:Boolean=true
    private var isServer:Boolean = true


    fun getliveData(): LiveData<AppState> {
        return liveData
    }

    fun getRussianWeather() {
        isRussian = true
        getWeather()
    }

    fun getWorldWeather() {
        isRussian = false
        getWeather()
    }

    fun getWeatherFromServer() {
        isServer = true
        getWeather()
    }

    fun getWeatherFromLocal() {
        isServer = false
        getWeather()
    }

    private fun getWeather() {

        Thread {
            if (isServer) {
                // liveData.postValue(AppState.Loading)
                val answer = if (isRussian) repository.getRussianWeatherFromServer() else
                    repository.getWorldWeatherFromServer()
                liveData.postValue(AppState.Success(answer))
            }
            if (!isServer) {
                //liveData.postValue(AppState.Loading)
                val answer = if (isRussian) repository.getRussianWeatherFromLocalSt() else
                    repository.getWorldWeatherFromLocalSt()
                liveData.postValue(AppState.Success(answer))

            }
        }.start()
    }

}