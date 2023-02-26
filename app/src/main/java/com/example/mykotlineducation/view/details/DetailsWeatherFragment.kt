package com.example.mykotlineducation.view.details

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.mykotlineducation.BuildConfig
import com.example.mykotlineducation.databinding.FragmentWeatherDetailsBinding
import com.example.mykotlineducation.repository.*
import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO
import com.example.mykotlineducation.utils.*
import com.example.mykotlineducation.viewmodel.*
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class DetailsWeatherFragment : Fragment() {
    var _binding: FragmentWeatherDetailsBinding? = null
    private val binding: FragmentWeatherDetailsBinding
        get() {
            return _binding!!
        }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun Toast.weather(mes: String) {
        Toast.makeText(requireContext(), mes, Toast.LENGTH_LONG).show()
    }


    lateinit var localNameCity: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
            val observer = object : Observer<DetailsState> {
                override fun onChanged(t: DetailsState) {
                    answer(t)
                }
            }
            viewModel.getLivedata().observe(viewLifecycleOwner, observer)

           it.getParcelable<Weather>(BUNDLE_WEATHER_KEY)?.let {weather ->
               viewModel.getWeather(weather.city)
           }
        }

    }


    fun answer(detailsState: DetailsState){
        when(detailsState){
            is DetailsState.Success -> renderData(detailsState.whetherData)
            is DetailsState.Error -> TODO()
            DetailsState.Loading -> TODO()
        }
    }


    fun renderData(weather: Weather) {
        binding.let {
            it.cityName.text = weather.city.name
            it.cityCoordinates.text =
                "${weather.city.lat.toString()}  ${weather.city.lon.toString()}"
            it.temperatureValue.text = weather.temperature.toString()
            it.feelsLikeValue.text = weather.feelsLike.toString()
        }
    }


    companion object {
        fun newInstance(bundle: Bundle): DetailsWeatherFragment {
            val fragment = DetailsWeatherFragment()
            fragment.arguments = bundle
            return fragment
        }
    }






}