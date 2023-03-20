package com.example.mykotlineducation.domain

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HistoryEntity::class), version = 1)
abstract class MyDB:RoomDatabase() {
    abstract fun historyDao():HistoryDao
}