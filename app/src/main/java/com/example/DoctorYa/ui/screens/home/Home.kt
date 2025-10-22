package com.example.DoctorYa.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier


import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.UiState


@Composable
fun Home(viewmodel: HomeViewModel = hiltViewModel(), navigateToSave: () -> Unit) {



    var texto by remember { mutableStateOf(" user@gmail.com") }
    val state by viewmodel.state.collectAsStateWithLifecycle()



     when(state) {
         is UiState.Error -> { Box(modifier = Modifier.fillMaxSize().background(color = Color.Red))

         }


         UiState.Loading -> {Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

             CircularProgressIndicator()
         }}





         is UiState.Success ->{


             Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                 Column(
                     Modifier.fillMaxSize(),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally
                 ) {
                     val users: List<user> = (state as UiState.Success<List<user>>).data


                     LazyColumn(modifier = Modifier.fillMaxWidth().weight(3f),
                         flingBehavior = ScrollableDefaults.flingBehavior(),
                         state = rememberLazyListState(),
                         horizontalAlignment = Alignment.CenterHorizontally,
                         content = { items(users) { user ->

                             Row(modifier = Modifier.fillMaxWidth().padding(10.dp,5.dp,10.dp,5.dp)) {

                                 Column(modifier = Modifier.fillMaxWidth().weight(1f)) { Text(text = user.name) }
                                 Column (modifier = Modifier.fillMaxWidth().weight(1f)){ Text(text = user.email) }
                                 Column(modifier = Modifier.fillMaxWidth().weight(1f)) { Text(text = user.username) }

                             }


                         }}
                         )

                     Spacer(modifier = Modifier.height(8.dp))

                     Column(modifier = Modifier.fillMaxWidth().weight(1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

                         Text(text = texto )
                         Spacer(modifier = Modifier.height(8.dp))

                         OutlinedButton(onClick = { navigateToSave() }) {

                             Text(text = "Click ")
                         }
                     }

                 }



         }
     }


}}