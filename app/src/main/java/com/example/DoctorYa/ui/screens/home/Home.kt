package com.example.DoctorYa.ui.screens.home

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.navigation3.runtime.rememberNavBackStack

import com.example.DoctorYa.ui.screens.components.BottonBarComponent
import com.example.DoctorYa.ui.screens.components.TopAppBarComponent
import com.example.DoctorYa.utils.navigation.NavigationMenu
import com.example.DoctorYa.utils.navigation.RouteMenu

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var selected by remember { mutableStateOf(0) }

    val backStack= rememberNavBackStack(RouteMenu.Profile)




    Scaffold(
        topBar = {TopAppBarComponent(title = "DoctorYa")},
        bottomBar = {BottonBarComponent(selected = selected, onClick = {route, index ->

            backStack.add(route)
            selected = index

        })},
        floatingActionButton = { }


    ) { paddingValues ->

        NavigationMenu(backStack = backStack)
    }

}

