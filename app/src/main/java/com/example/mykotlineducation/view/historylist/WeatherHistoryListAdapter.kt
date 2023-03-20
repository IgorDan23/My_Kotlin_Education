package com.example.mykotlineducation.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlineducation.databinding.FragmentWeatherHistoryListBinding
import com.example.mykotlineducation.databinding.FragmentWeatherHistoryRecyclerItemBinding
import com.example.mykotlineducation.databinding.FragmentWeatherRecyclerItemBinding
import com.example.mykotlineducation.repository.Weather

class WeatherHistoryListAdapter(private var data: List<Weather> = listOf()) :
    RecyclerView.Adapter<WeatherHistoryListAdapter.HistoryCityHolder>() {


    fun setData(dataNew: List<Weather>) {
        this.data = dataNew
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryCityHolder {
        val binding = FragmentWeatherHistoryRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryCityHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HistoryCityHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

   inner class HistoryCityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            val binding = FragmentWeatherHistoryRecyclerItemBinding.bind(itemView)
            binding.cityName.text=weather.city.name
            binding.temperatureLabel.text=weather.temperature.toString()

        }
    }
}