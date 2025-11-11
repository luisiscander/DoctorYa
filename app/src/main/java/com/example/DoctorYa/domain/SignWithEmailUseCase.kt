package com.example.DoctorYa.domain

import com.example.DoctorYa.data.Repository
import com.example.DoctorYa.data.model.userRequest
import javax.inject.Inject

class SignWithEmailUseCase @Inject constructor(private val repository: Repository) {

 suspend  operator fun invoke(request: userRequest)= repository.signWithEmail(request)
}