package com.example.DoctorYa.ui.screens.save

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.DoctorYa.domain.GetUsersDb
import com.example.DoctorYa.domain.GetUsersUseCase
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.Result
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
class SaveViewModel @Inject constructor(
    getUsersDb: GetUsersDb
): ViewModel() {


       val state: StateFlow<UiState<List<user>>> = getUsersDb().map { result ->

          when(result) {
              is Result.Error<*> -> {
                  UiState.Error(message = result.message)
              }
              is Result.Success<*> -> {
                  val info: List<user>? = result.data as? List<user>

                  UiState.Success<List<user>>(data= info?: emptyList())
              }
          }
       }//.onStart { emit(UiState.Loading)}
           .stateIn(scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(500),
                     initialValue = UiState.Loading)










    }


