package com.example.DoctorYa.data.firebase

import com.example.DoctorYa.data.FireBaseDataSource

import com.example.DoctorYa.data.model.userRequest
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthResult

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.GoogleAuthProvider

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseDataSourceImpl @Inject constructor(private val firebase: FirebaseAuth): FireBaseDataSource {


    override suspend fun getSignWithEmail(request: userRequest): AuthResult {

        return withContext(Dispatchers.IO){

    firebase.signInWithEmailAndPassword(request.email,request.password).await()


        }
    }

    override suspend fun getSignWthGoogle(account: GoogleSignInAccount): AuthResult {
        return withContext(Dispatchers.IO){
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            firebase.signInWithCredential(credential).await()

        }
    }
}