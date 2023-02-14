package com.example.mykotlineducation.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mykotlineducation.databinding.FragmentWeatherDetailsBinding
import com.example.mykotlineducation.repository.OnServerResponse
import com.example.mykotlineducation.repository.Weather
import com.example.mykotlineducation.repository.WeatherDTO
import com.example.mykotlineducation.repository.WeatherLoader
import com.example.mykotlineducation.utils.BUNDLE_WEATHER_KEY


class DetailsWeatherFragment : Fragment(), OnServerResponse {
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
        val weather = arguments?.getParcelable<Weather>(BUNDLE_WEATHER_KEY)?.let {
           WeatherLoader(this).loadWeather(it.city.let,it.city.lon)
            Toast(requireContext()).weather("работает")
            localNameCity=it.city.name.toString()
        }


    }

    fun renderData(weatherDto: WeatherDTO) {
        binding.let {
            it.cityName.text = localNameCity
            it.cityCoordinates.text =
                "${weatherDto.info.lat.toString()}  ${weatherDto.info.lon.toString()}"
            it.temperatureValue.text = weatherDto.fact.temperature.toString()
            it.feelsLikeValue.text = weatherDto.fact.feelsLike.toString()
        }
    }


    companion object {
        fun newInstance(bundle: Bundle): DetailsWeatherFragment {
            val fragment = DetailsWeatherFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onResponse(weatherDTO: WeatherDTO) {
        renderData(weatherDTO)
    }
}