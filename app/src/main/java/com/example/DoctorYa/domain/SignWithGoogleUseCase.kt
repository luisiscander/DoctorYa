package com.example.DoctorYa.domain

import com.example.DoctorYa.data.Repository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import javax.inject.Inject

class SignWithGoogleUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(account: GoogleSignInAccount) = repository.signWithGoogle(account = account)
}