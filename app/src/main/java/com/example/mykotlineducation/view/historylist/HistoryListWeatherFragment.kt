package com.example.mykotlineducation.view.weatherlist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlineducation.R
import com.example.mykotlineducation.databinding.FragmentWeatherHistoryListBinding
import com.example.mykotlineducation.utils.BUNDLE_WEATHER_KEY
import com.example.mykotlineducation.view.details.DetailsWeatherFragment
import com.example.mykotlineducation.viewmodel.AppState
import com.example.mykotlineducation.viewmodel.HistoryViewModel
import com.example.mykotlineducation.viewmodel.MainViewModel


class HistoryListWeatherFragment : Fragment() {
    var _binding: FragmentWeatherHistoryListBinding? = null
    private val binding: FragmentWeatherHistoryListBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    private val adapter = WeatherHistoryListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentWeatherHistoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.weatherRecyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)
        val observer = object : Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)


            }
        }
        viewModel.getliveData().observe(viewLifecycleOwner, observer)
        viewModel.getAll()
    }

    fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> TODO()
            is AppState.Loading -> TODO()
            is AppState.Success -> {
                adapter.setData(data.whetherData)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.history).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }


    companion object {
        fun newInstance() = HistoryListWeatherFragment()
    }



}