package com.example.mykotlineducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlineducation.repository.Repository
import com.example.mykotlineducation.repository.RepositoryImp


class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImp = RepositoryImp()
) : ViewModel() {


    fun getliveData(): LiveData<AppState> {
        return liveData
    }

    fun getWeather(type: Int) {
        Thread {

                    if(type==0){
                        liveData.postValue(AppState.Loading)
                        liveData.postValue(AppState.Success(repository.getWeatherFromServer()))
                    } else{
                        liveData.postValue(AppState.Loading)
                        liveData.postValue(AppState.Success(repository.getWeatherFromLocalSt()))
                    }
             }.start()
    }

}