package com.example.mykotlineducation.viewmodel

import com.example.mykotlineducation.repository.Weather

sealed class AppState{
    object Loading :AppState()
    data class Success(val whetherData:Weather) :AppState()
    data class Error(val error: Throwable) :AppState()
}
