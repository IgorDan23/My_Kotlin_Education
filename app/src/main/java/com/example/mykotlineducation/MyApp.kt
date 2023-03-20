package com.example.mykotlineducation

import android.app.Application
import android.net.ConnectivityManager
import androidx.room.Room
import com.example.mykotlineducation.domain.HistoryDao
import com.example.mykotlineducation.domain.MyDB

class MyApp: Application() {


    override fun onCreate() {
        super.onCreate()
        appContext=this


    }



    companion object{
        private var db:MyDB?=null
        private var appContext:MyApp?=null

        fun getHistoryDao():HistoryDao{
            if (db==null){

                db=Room.databaseBuilder(appContext!!,MyDB::class.java,"test")
                    .allowMainThreadQueries().build()
            }
                return db!!.historyDao()

        }

    }
}