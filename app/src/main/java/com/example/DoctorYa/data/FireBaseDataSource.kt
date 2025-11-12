package com.example.DoctorYa.data

import com.example.DoctorYa.data.model.userRequest
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthResult

interface FireBaseDataSource  {

    suspend fun getSignWithEmail(request: userRequest):AuthResult

    suspend fun  getSignWthGoogle(account: GoogleSignInAccount): AuthResult
}