package com.example.mykotlineducation.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlineducation.databinding.FragmentWeatherRecyclerItemBinding
import com.example.mykotlineducation.repository.Weather

class WeatherListAdapter(private val onItemClick:OnItemClick,
                         private var data: List<Weather> = listOf()) :
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

   inner class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            val binding = FragmentWeatherRecyclerItemBinding.bind(itemView)
            binding.cityName.text = weather.city.name
            binding.weatherItem.setOnClickListener {
                onItemClick.OnClick(weather)
            }
        }
    }
}