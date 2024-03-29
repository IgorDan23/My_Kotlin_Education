package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlineducation.repository.*

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsState> = MutableLiveData(),
    private val repositoryRoom: DetailsRepositoryAddWeather = RoomRepositoryImp(),
    private val repository: DetailsRepositoryInter = Retrofit2Repository()
) : ViewModel()  {
    fun getLivedata() = liveData

    fun getWeather(city: City){
        repository.getWeatherFromRepository(city
        ) {
            liveData.postValue(DetailsState.Success(it))
            repositoryRoom.addWeather(it)
        }

    }

   fun interface CallbackWeather {
        fun onResponse(weather: Weather)
    }
    fun interface CallbackAllWeather {
        fun onResponse(listWeather: List<Weather>)
    }

}