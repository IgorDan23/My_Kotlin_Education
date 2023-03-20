package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlineducation.repository.RoomRepositoryImp
import com.example.mykotlineducation.repository.Weather


class HistoryViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RoomRepositoryImp = RoomRepositoryImp()
) : ViewModel() {


    fun getliveData(): LiveData<AppState> {
        return liveData
    }


     fun getAll() {
        repository.getAllWeatherFromRepository(object : CallbackAllWeather{
            override fun onResponse(listWeather: List<Weather>) {
                liveData.postValue(AppState.Success(listWeather))
            }

        })

    }

    fun interface CallbackAllWeather {
        fun onResponse(listWeather: List<Weather>)
    }
}




