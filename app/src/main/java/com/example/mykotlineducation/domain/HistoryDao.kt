package com.example.mykotlineducation.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mykotlineducation.repository.City

@Dao
interface HistoryDao {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    fun insert(entity: HistoryEntity)

    @Delete
    fun  delete(entity: HistoryEntity)

    @Update
    fun update(entity: HistoryEntity)

    @Query("SELECT * FROM historyTable")
    fun getAll():List<HistoryEntity>

    @Query("SELECT * FROM historyTable WHERE city=:city")
    fun getHistoryForCity(city: String):List<HistoryEntity>
}