package com.example.mykotlineducation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlineducation.R
import com.example.mykotlineducation.view.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_cont,
                MainFragment.newInstance()
            ).commit()
        }
    }
}