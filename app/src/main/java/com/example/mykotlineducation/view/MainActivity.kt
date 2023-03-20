package com.example.mykotlineducation.view

import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlineducation.R
import com.example.mykotlineducation.view.weatherlist.HistoryListWeatherFragment
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_cont, HistoryListWeatherFragment.newInstance()
                ).addToBackStack("")
                    .commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}