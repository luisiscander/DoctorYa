package com.example.DoctorYa.ui.screens.save

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.UiState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.geometry.isEmpty


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SaveScreen(viewModel: SaveViewModel = hiltViewModel())
{
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    //var textToSave by remember { mutableStateOf("") }


        Box(modifier=Modifier.fillMaxSize()){

            when(val state= uiState) {
                is UiState.Error -> {
                    Box(modifier = Modifier.fillMaxSize().background(color = Color.Red))
                }
                UiState.Loading -> {
                    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                        CircularProgressIndicator()
                    }
                }
                is UiState.Success<List<user>> -> {
                    val users: List<user> = state.data
                    if (users.isEmpty()) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "No hay usuarios guardados.")
                        }
                    } else {


                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(users) { info: user ->
                                Text(text = info.name )
                            }
                        }
                    }



                }



            }


        }

        }


