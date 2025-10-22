package com.example.DoctorYa.utils

sealed class Result<T>( data: T? =null, message: String? = null) {

    data class Success<T>(val data :T?): Result<T>(data=data)

    data class Error<T>( val message: String): Result<T>(message = message)


}