package com.example.DoctorYa.data.Remote

import com.example.DoctorYa.data.model.userDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {


    @GET("/users")
    suspend fun getUsers(): Response<List<userDto>>

}