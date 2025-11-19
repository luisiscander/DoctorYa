package com.example.DoctorYa.ui.screens.home

import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

   // var selected by remember { mutableStateOf(0) }

     val backStack= rememberNavBackStack(RouteMenu.Profile)
     val currentRoute: NavKey? by remember( backStack){
         derivedStateOf { backStack.lastOrNull() }
     }



    Scaffold(
        topBar = {TopAppBarComponent(title = "DoctorYa")},
        bottomBar = {BottonBarComponent( currentRoute = currentRoute , onClick = {route ->

            backStack.add(route)


        })},
        floatingActionButton = { }


    ) { paddingValues ->

        NavigationMenu(backStack = backStack, modifier = Modifier.padding(paddingValues = paddingValues))
    }

}

