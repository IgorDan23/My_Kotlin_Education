package com.example.mykotlineducation.viewmodel

import com.example.mykotlineducation.repository.Weather

sealed class DetailsState{
    object Loading :DetailsState()
    data class Success(val whetherData:Weather) :DetailsState()
    data class Error(val error: Throwable) :DetailsState()
}
