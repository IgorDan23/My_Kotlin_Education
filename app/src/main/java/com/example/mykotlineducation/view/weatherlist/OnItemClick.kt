package com.example.mykotlineducation.view.weatherlist

import com.example.mykotlineducation.repository.Weather

interface OnItemClick {
    fun OnClick(weather: Weather)
}