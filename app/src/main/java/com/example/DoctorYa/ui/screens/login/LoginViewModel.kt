package com.example.DoctorYa.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DoctorYa.data.model.userRequest
import com.example.DoctorYa.domain.SignWithEmailUseCase
import com.example.DoctorYa.utils.FirebaseHelper
import com.example.DoctorYa.utils.UiState
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor( private val firebase: SignWithEmailUseCase): ViewModel()  {
    /*
    *private val _state = MutableStateFlow<UiState<List<user>>>(UiState.Loading)
    val state: StateFlow<UiState<List<user>>> = _state
    * 
    * */
      
   private val _loginState= MutableStateFlow<UiState<Unit>>(UiState.Inactive)
    val loginState = _loginState

     fun signWithEmail(request: userRequest)= viewModelScope.launch{

        _loginState.value= UiState.Loading
        try {
            firebase(request = request)
            _loginState.value= UiState.Success(Unit)


        }catch (e: Exception){

            _loginState.value = UiState.Error(e.message?:"Invalid Credentials")
        }

    }
      


    fun resetState() {_loginState.value = UiState.Inactive}




}