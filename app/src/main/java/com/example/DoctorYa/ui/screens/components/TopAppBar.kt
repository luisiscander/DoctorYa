package com.example.DoctorYa.ui.screens.components

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(modifier: Modifier = Modifier, title: String) {

    CenterAlignedTopAppBar(
        modifier = modifier,

        navigationIcon = { IconButton(onClick = {}) { Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu") }},

        title = { Text(text = title) },

        actions = { IconButton(onClick = {}) { Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notification Icon") }}

    )


}