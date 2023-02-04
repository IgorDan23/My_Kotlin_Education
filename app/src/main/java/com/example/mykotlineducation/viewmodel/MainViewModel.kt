package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveData:MutableLiveData<AppState> = MutableLiveData()):ViewModel() {
    fun getliveData():LiveData<AppState>{
        return liveData
    }

    fun getWeather(){
        Thread {
            liveData.postValue(AppState.Loading)
            sleep(3000)
            liveData.postValue(AppState.Success(Any()))
        }.start()
    }

}