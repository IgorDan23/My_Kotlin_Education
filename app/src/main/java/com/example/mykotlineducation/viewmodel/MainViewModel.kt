package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveData:MutableLiveData<Any> = MutableLiveData()):ViewModel() {
    fun getliveData():LiveData<Any>{
        return liveData
    }

    fun getWeather(){
        Thread {
            sleep(3000)
            liveData.postValue(Any())
        }.start()
    }

}