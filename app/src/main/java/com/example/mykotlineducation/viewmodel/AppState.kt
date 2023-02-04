package com.example.mykotlineducation.viewmodel

sealed class AppState{
    object Loading :AppState()
    data class Success(val whetherData:Any) :AppState()
    data class Error(val error: Throwable) :AppState()
}
