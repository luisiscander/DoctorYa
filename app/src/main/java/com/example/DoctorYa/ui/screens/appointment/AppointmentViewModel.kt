package com.example.DoctorYa.ui.screens.appointment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.DoctorYa.domain.GetUsersUseCase
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.helpers.Result
import com.example.DoctorYa.utils.helpers.UiState
import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

import javax.inject.Inject



@HiltViewModel
class AppointmentViewModel @Inject constructor( private val getUsersUseCase: GetUsersUseCase): ViewModel() {


    val state: StateFlow<UiState<List<user>>> =  getUsersUseCase().map { value ->
        when(value) {
            is Result.Error -> {
                UiState.Error(message = value.message)
            }
            is Result.Success<List<user>> -> {
                if(!value.data.isNullOrEmpty()){
                    UiState.Success(data = value.data)
                }else{
                    UiState.Error(message ="data empty")
                }
            }
        }


    }.onStart { emit(UiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500),
            initialValue = UiState.Loading

        )


/*
    private  var  _state  = MutableStateFlow<UiState<List<user>>>(UiState.Loading)
      val state: MutableStateFlow<UiState<List<user>>> = _state




    fun getUsers()=viewModelScope.launch {

        _state.value= UiState.Loading
       getUsersUseCase().collectLatest { result: Result<List<user>> ->
        _state.value =  when(result) {
                is Result.Error<*> -> {
                    UiState.Error(result.message)
                }
                is Result.Success -> {
                    if(!result.data.isNullOrEmpty()){
                       UiState.Success(data = result.data)
                    }else{
                        UiState.Error(message = "Empty data")
                    }

                }
            }


        }

    }
*/



}