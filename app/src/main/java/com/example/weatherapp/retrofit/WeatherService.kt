package com.example.weatherapp.retrofit

import com.example.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

public interface WeatherService {
    //api key = f527116930dcfc6f62460f3c4b97d495
    @GET("weather?appid=f527116930dcfc6f62460f3c4b97d495&units=metric")
    suspend fun getWeather(@Query("q")name: String) : Response<WeatherModel>
}