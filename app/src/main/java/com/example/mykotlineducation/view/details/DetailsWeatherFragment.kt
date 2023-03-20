package com.example.mykotlineducation.view.details

import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.mykotlineducation.databinding.FragmentWeatherDetailsBinding
import com.example.mykotlineducation.repository.Weather
import com.example.mykotlineducation.utils.BUNDLE_WEATHER_KEY
import com.example.mykotlineducation.viewmodel.DetailsState
import com.example.mykotlineducation.viewmodel.DetailsViewModel
import com.example.mykotlineducation.viewmodel.MyBroadcastReceiver
import kotlinx.android.synthetic.main.fragment_weather_details.*


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

            it.getParcelable<Weather>(BUNDLE_WEATHER_KEY)?.let { weather ->
                viewModel.getWeather(weather.city)
            }
        }

    }


    fun answer(detailsState: DetailsState) {
        when (detailsState) {
            is DetailsState.Success -> renderData(detailsState.whetherData)
            is DetailsState.Error -> TODO()
            DetailsState.Loading -> TODO()
        }
    }


    fun renderData(weather: Weather) {
        binding.let {
           iconCity.load("https://www.pngall.com/wp-content/uploads/11/City-PNG-Image.png")
            iconWeather.loadSvg("https://yastatic.net/weather/i/icons/funky/dark/${weather.icon}.svg")
            it.cityName.text = weather.city.name
            it.cityCoordinates.text =
                "${weather.city.lat.toString()}  ${weather.city.lon.toString()}"
            it.temperatureValue.text = weather.temperature.toString()
            it.feelsLikeValue.text = weather.feelsLike.toString()
        }
    }

    fun ImageView.loadSvg(url: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .target(this)
            .data(url)
            .build()
        imageLoader.enqueue(request)

    }


    companion object {
        fun newInstance(bundle: Bundle): DetailsWeatherFragment {
            val fragment = DetailsWeatherFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


}