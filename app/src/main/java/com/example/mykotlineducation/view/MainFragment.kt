package com.example.mykotlineducation.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlineducation.databinding.FragmentMainBinding
import com.example.mykotlineducation.viewmodel.AppState
import com.example.mykotlineducation.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar.make


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = object : Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)
            }
        }
        viewModel.getliveData().observe(viewLifecycleOwner, observer)
        viewModel.getWeather(1)
        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.getWeather(0)
            } else {
                viewModel.getWeather(1)

            }
        }




    }

    @SuppressLint("SetTextI18n")
    fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> TODO()
            is AppState.Loading -> binding.progressBar.isVisible=true
            is AppState.Success -> {
                binding.progressBar.isVisible = false
                binding.cityName.text = data.whetherData.city.name
                binding.cityCoordinates.text =
                    "${data.whetherData.city.let.toString()} ${data.whetherData.city.lon.toString()}"
                binding.temperatureValue.text = data.whetherData.temperature.toString()
                binding.feelsLikeValue.text = data.whetherData.feelsLike.toString()


            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}