package com.example.mykotlineducation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlineducation.R
import com.example.mykotlineducation.view.weatherlist.ListWeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_cont,
                ListWeatherFragment.newInstance()
            ).commit()
        }
    }
}