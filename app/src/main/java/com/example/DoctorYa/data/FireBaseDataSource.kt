package com.example.DoctorYa.data

import com.example.DoctorYa.data.model.userRequest
import com.google.firebase.auth.AuthResult

interface FireBaseDataSource  {

    suspend fun getSignWithEmail(request: userRequest):AuthResult
}