package com.example.DoctorYa.ui.screens.login


import android.accounts.Account
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DoctorYa.data.model.userRequest
import com.example.DoctorYa.domain.SignWithEmailUseCase
import com.example.DoctorYa.domain.SignWithGoogleUseCase

import com.example.DoctorYa.utils.helpers.UiState
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signWithEmailUseCase: SignWithEmailUseCase,
     private val signWithGoogleUseCase: SignWithGoogleUseCase
): ViewModel()  {

      
   private val _loginState= MutableStateFlow<UiState<Unit>>(UiState.Idle)
    val loginState = _loginState

     fun signWithEmail(request: userRequest)= viewModelScope.launch{

        _loginState.value= UiState.Loading
        try {
            signWithEmailUseCase(request = request)
            _loginState.value= UiState.Success(Unit)


        }catch (e: Exception){

            _loginState.value = UiState.Error(e.message?:"Invalid Credentials")
        }

    }


    fun signWithGoogle(account: GoogleSignInAccount)= viewModelScope.launch {

        _loginState.value= UiState.Loading
        try {
            signWithGoogleUseCase(account = account)
            _loginState.value= UiState.Success(Unit)


        }catch (e: Exception){
            _loginState.value= UiState.Error(message = e.message?:"Try Again")
        }


    }
      


    fun resetState() {_loginState.value = UiState.Idle}




}