package com.example.DoctorYa.domain

import com.example.DoctorYa.data.Repository
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.Result
import com.example.DoctorYa.utils.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<Result<List<user>>> = repository.getUsersFromApi()



}
