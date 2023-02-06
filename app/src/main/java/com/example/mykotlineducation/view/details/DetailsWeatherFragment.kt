package com.example.mykotlineducation.view.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mykotlineducation.databinding.FragmentWeatherDetailsBinding


class DetailsWeatherFragment : Fragment() {
    var _binding: FragmentWeatherDetailsBinding?=null
    private val binding:FragmentWeatherDetailsBinding
    get() {
        return _binding!!
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    @SuppressLint("SetTextI18n")
/*  fun renderData(data: AppState) {
      when (data) {
          is AppState.Error -> TODO()
          is AppState.Success -> {
              binding.cityName.text = data.whetherData.city.name
              binding.cityCoordinates.text =
                  "${data.whetherData.city.let.toString()}  ${data.whetherData.city.lon.toString()}"
              binding.temperatureValue.text = data.whetherData.temperature.toString()
              binding.feelsLikeValue.text = data.whetherData.feelsLike.toString()


          }
      }
  } */

  companion object {
      fun newInstance() = DetailsWeatherFragment()
  }
}