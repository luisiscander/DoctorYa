package com.example.DoctorYa.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DoctorYa.domain.GetUsersDb
import com.example.DoctorYa.utils.Result
import com.example.DoctorYa.domain.GetUsersUseCase
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val getUsersUseCase: GetUsersUseCase,

) : ViewModel() {

     val state: StateFlow<UiState<List<user>>> = getUsersUseCase().map { result ->

        when(result) {
            is Result.Error -> {
                UiState.Error(message = result.message )
            }
            is Result.Success -> {

                UiState.Success<List<user>>(data = result.data?:emptyList())
            }
        }

    }.onStart { emit(UiState.Loading) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500),
            initialValue = UiState.Loading)









/*
    private val _state = MutableStateFlow<UiState<List<user>>>(UiState.Loading)
    val state: StateFlow<UiState<List<user>>> = _state


    init {
        viewModelScope.launch {

            getUsers()
        }

    }

    fun getUsers() {
        viewModelScope.launch {

            val users: Flow<Result<List<user>>> = getUsersUseCase()

            users
                .onStart { UiState.Loading }
                .collect { result: Result<List<user>> ->
                    _state.value = when (result) {
                        is Result.Error -> {
                            UiState.Error(message = result.message)
                        }

                        is Result.Success -> {
                            UiState.Success(data = result.data ?: emptyList())
                        }
                    }

                }


        }


    }


    /*fun getUsers1() {
        viewModelScope.launch {

            _state1.value = UiState.Loading

            val response = getUsersUseCase()

            when (response) {
                is Result.Error -> {
                    _state1.value = UiState.Error(message = response.message )
                }

                is Result.Success -> {
                    if (!response.data.isNullOrEmpty()){
                    _state1.value = UiState.Success(data = response.data)}
                    else{

                       _state1.value= UiState.Error(message = " No data found")
                    }
                }

            }


        }


    }*/


    /*fun getUsers() {

        viewModelScope.launch {


            val result: Result<List<user>> = getUsersUseCase()

            when (result) {
                is Result.Error -> {
                    state = state.copy(users = null, error = result.message)
                }

                is Result.Success -> {

                    state = state.copy(users = result.data, error = null)

                }
                /*val id: Int,
val name: String,
val username: String,
val email: String*/

            }


        }

    }*/
*/
}


data class UiState2(

    val loading: Boolean = false,
    val error: String? = null,
    val users: List<user>? = null
)



