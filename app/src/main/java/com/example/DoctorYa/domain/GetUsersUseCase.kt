package com.example.DoctorYa.domain

import com.example.DoctorYa.data.Repository
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.helpers.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<Result<List<user>>> = repository.getUsersFromApi()



}
