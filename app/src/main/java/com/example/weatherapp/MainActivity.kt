package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.retrofit.RetrofitInstance
import com.example.weatherapp.retrofit.WeatherService
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.searchImage.setOnClickListener {
            getWeatherData(binding.citySearch.text.toString())
        }
    }


    fun getWeatherData(name: String) {
        val weatherService =
            RetrofitInstance.getRetrofitInstance().create(WeatherService::class.java)

        val responseLiveData: LiveData<Response<WeatherModel>> = liveData {
            val response = weatherService.getWeather(name)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
           val result = it.body()
            if(result != null) {
                binding.tvTemp.text = result.main.temp.toString()
                binding.tvOpis.text = result.weather.get(0).description.toString()
                binding.tvVlaznost.text = result.main.humidity.toString()
            }
        }
        )


    }

}