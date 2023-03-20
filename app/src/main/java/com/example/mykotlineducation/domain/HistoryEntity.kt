package com.example.mykotlineducation.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity (tableName = "historyTable")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val city:String,
    val temperature:Int,
    val feelsLike:Int,
    val icon:String


)
