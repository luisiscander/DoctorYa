package com.example.DoctorYa.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitHelper {


    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}