package com.example.DoctorYa.ui.screens.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.helpers.UiState

enum class Action{
    CLONE, DELETE
}


@Composable
fun AppointmentScreen(viewModel: AppointmentViewModel= hiltViewModel()) {
/*
    val uistate by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {

        viewModel.getUsers()
    }
*/
    val uistate by viewModel.state.collectAsStateWithLifecycle()


Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

    when(uistate) {
        is UiState.Error -> {Text(text =(uistate as? UiState.Error)?.message?:"Error" )}
        UiState.Idle -> {}
        UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                CircularProgressIndicator()
            }

        }
        is UiState.Success -> {
            LazyColumn (
                modifier = Modifier.fillMaxSize(),
                 contentPadding = WindowInsets.statusBars.asPaddingValues()
            ){
                val data: List<user>? = (uistate as? UiState.Success)?.data

                data?.let { items->
                    itemsIndexed(items, key = {_, item->item.id} ){index, user->
                        var expanded by remember { mutableStateOf(false) }
                        if (index>0) HorizontalDivider()
                        ListItem(
                            headlineContent = {Text(user.username)},
                            supportingContent = {Text(text = user.email)},
                            trailingContent = {
                                IconButton(onClick = {expanded= !expanded}) {
                                    Image(imageVector = Icons.Filled.MoreVert, contentDescription = "")

                                }
                                DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false}) {

                                    DropdownMenuItem(
                                        onClick = {expanded=false },
                                        text = {Text("Delete")}
                                    )

                                    DropdownMenuItem(
                                        onClick = {expanded=false},
                                        text = {Text(text = "Clone")}
                                    )
                                }



                            }


                        )


                    }

                }


            }
        }
    }


}







    }


