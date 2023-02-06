package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlineducation.repository.RepositoryImp


class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImp = RepositoryImp()
) : ViewModel() {


    fun getliveData(): LiveData<AppState> {
        return liveData
    }

    fun getRussianWeatherFromLocal()=getWeather(isServer = false, isRussian = true)
    fun getWorldWeatherFromLocal()=getWeather(false,false)
    fun getRussianWeatherFromServer()=getWeather(true,true)
    fun getWorldWeatherFromServer()=getWeather(true,false)

   private fun getWeather(isServer: Boolean, isRussian: Boolean) {
        Thread {
            if (isServer) {
               // liveData.postValue(AppState.Loading)
                liveData.postValue(AppState.Success(repository.getWeatherFromServer()))
            }
            if (!isServer) {
                //liveData.postValue(AppState.Loading)
                val answer = if(isRussian) repository.getRussianWeatherFromLocalSt() else
                    repository.getWorldWeatherFromLocalSt()
                liveData.postValue(AppState.Success(answer))

            }
        }.start()
    }

}