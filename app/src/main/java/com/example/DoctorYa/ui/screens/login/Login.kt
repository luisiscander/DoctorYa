package com.example.DoctorYa.ui.screens.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.example.DoctorYa.R
import com.example.DoctorYa.data.model.userRequest
import com.example.DoctorYa.ui.screens.components.CmpButton
import com.example.DoctorYa.ui.screens.components.CmpTextField
import com.example.DoctorYa.ui.screens.components.Type
import com.example.DoctorYa.utils.UiState

@Composable
fun Login(loginViewModel: LoginViewModel= hiltViewModel(), navigateTo: ()-> Unit) {


    val uiState  by loginViewModel.loginState.collectAsStateWithLifecycle()
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isError = uiState is UiState.Error



Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){


    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //header
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1.5f), contentAlignment = Alignment.Center)
        {
            Image(
                painter = painterResource(R.drawable.ic_person), contentDescription = "profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize(0.5f)
            )

        }

        //body
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Card(modifier = Modifier.fillMaxSize(),
                elevation = CardDefaults.cardElevation(2.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(width = 1.dp, color = Color.Transparent)
            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){


                     AnimatedVisibility(isError) {
                         val errorMesage= (uiState as? UiState.Error)?.message?:"error..try again"
                         Text(text = errorMesage,
                             modifier = Modifier.padding(bottom = 8.dp),
                             color = Color.Red,
                             style = MaterialTheme.typography.bodySmall,
                             fontWeight = FontWeight.Bold
                             )
                     }

                    CmpTextField( type = Type.User, value = user, isError = isError){user = it}

                    Spacer(modifier = Modifier.height(10.dp))

                    CmpTextField(type = Type.Password, value = password, isError = isError) {password=it}

                    Spacer(modifier = Modifier.height(16.dp))

                    CmpButton(enable = (uiState != UiState.Loading)){
                        val auth= userRequest(email = user, password = password)
                        loginViewModel.signWithEmail(auth)

                    }
                }

            }

        }

        //footer
        Row(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                "copy-right-2025",
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
            )
        }


    }


    LaunchedEffect(uiState) {
        if (uiState is UiState.Success){
            navigateTo()
            loginViewModel.resetState()

        }

    }

    when(uiState) {
        is UiState.Error -> {

           isError=!isError
        }
        UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
           }

        UiState.Inactive -> {}
    }


}


}

