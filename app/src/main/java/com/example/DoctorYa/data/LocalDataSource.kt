package com.example.DoctorYa.data

import com.example.DoctorYa.data.model.userEntity
import com.example.DoctorYa.utils.Result
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getUsersDb(): Flow<Result<List<userEntity>>>
    suspend fun insertUsers(users: List<userEntity>)
    suspend fun clearDB()
}