package com.example.DoctorYa.data

import com.example.DoctorYa.data.model.userDto
import com.example.DoctorYa.data.model.userEntity
import com.example.DoctorYa.utils.helpers.Result
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllUsers(): Flow<Result<List<userDto>>>

}