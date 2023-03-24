package com.example.weatherapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitInstance {
    companion object{
      //  val BASE_ULR = "http://api.openweathermap.org/data/2.5/weather"

        fun getRetrofitInstance() : Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(
                    GsonConverterFactory
                        .create(
                            GsonBuilder()
                            .create())
                )
                .build()

        }
    }
}