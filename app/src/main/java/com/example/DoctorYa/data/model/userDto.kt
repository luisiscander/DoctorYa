package com.example.DoctorYa.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class userDto(
    @SerializedName("id")  val id: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("username")  val username: String,
    @SerializedName("email")  val email: String
)
