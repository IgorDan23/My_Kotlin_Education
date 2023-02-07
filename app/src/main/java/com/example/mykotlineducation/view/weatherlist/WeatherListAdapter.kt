package com.example.mykotlineducation.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlineducation.databinding.FragmentWeatherListBinding
import com.example.mykotlineducation.databinding.FragmentWeatherRecyclerItemBinding
import com.example.mykotlineducation.repository.Weather

class WeatherListAdapter(private var data: List<Weather> = listOf()) :
    RecyclerView.Adapter<WeatherListAdapter.CityHolder>() {
    fun setData(dataNew: List<Weather>) {
        this.data = dataNew
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val binding = FragmentWeatherRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            val binding = FragmentWeatherRecyclerItemBinding.bind(itemView)
            binding.cityName.text = weather.city.name
            val temp = weather.temperature
            binding.temp.text = if (temp > 0) {
                ("${"+"}${weather.temperature}")
            } else {
                weather.temperature.toString()
            }
        }
    }
}