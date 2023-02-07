package com.example.mykotlineducation.view.weatherlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlineducation.R
import com.example.mykotlineducation.databinding.FragmentWeatherListBinding
import com.example.mykotlineducation.viewmodel.AppState
import com.example.mykotlineducation.viewmodel.MainViewModel


class ListWeatherFragment : Fragment() {
    var _binding: FragmentWeatherListBinding? = null
    private val binding: FragmentWeatherListBinding
        get() {
            return _binding!!
        }
    private var isRussia = false


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    private val adapter = WeatherListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.weatherRecyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = object : Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)
            }
        }
        viewModel.getliveData().observe(viewLifecycleOwner, observer)
        with(viewModel) {
            getRussianWeather()
            getWeatherFromServer()
        }
        viewModel.getRussianWeather()
        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.getWeatherFromLocal()
            } else {
                viewModel.getWeatherFromServer()
            }

        }
        binding.buttonCont.setOnClickListener {
            if (isRussia) {
                isRussia = false
                binding.buttonCont.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.russia
                    )
                )
                viewModel.getRussianWeather()
            } else {
                isRussia = true
                binding.buttonCont.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.earth
                    )
                )
                viewModel.getWorldWeather()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> TODO()
            is AppState.Loading -> TODO()
            is AppState.Success -> {
                adapter.setData(data.whetherData)
            }
        }
    }

    companion object {
        fun newInstance() = ListWeatherFragment()
    }
}