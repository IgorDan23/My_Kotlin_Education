package com.example.mykotlineducation.repository

data class Weather(val city: City = defaultCity(),val temperature:Int=0,val feelsLike:Int=0)

fun defaultCity()=City("Москва",55.45,36.37)

data class City(val name:String,val let:Double, val lon:Double)