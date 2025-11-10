package com.example.DoctorYa.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DoctorYa.utils.FirebaseHelper
import com.example.DoctorYa.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor( private val firebase: FirebaseHelper): ViewModel()  {
    /*
    *private val _state = MutableStateFlow<UiState<List<user>>>(UiState.Loading)
    val state: StateFlow<UiState<List<user>>> = _state
    * 
    * */
      
   private val _loginState= MutableStateFlow<UiState<Unit>>(UiState.Inactive)
    val loginState = _loginState
      

    
    fun signWithEmail(email: String, password:String) = viewModelScope.launch{
        _loginState.value = UiState.Loading
        
        try {
            val result = firebase.signInWithEmail(email = email, password = password)

            _loginState.value = UiState.Success(Unit)
            
        }catch (e: Exception){
            _loginState.value = UiState.Error(message = e.message?:"Invalid Credentials")
            
        }
        
    }

    fun resetState() {_loginState.value = UiState.Inactive}




}