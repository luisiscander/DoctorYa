package com.example.DoctorYa.ui.screens.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Approval
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.DoctorYa.utils.navigation.RouteMenu

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: RouteMenu


)

fun getNavigationItems(): List<NavigationItem>{

    return listOf(
        NavigationItem(title = "Profile", icon = Icons.Default.Person, route = RouteMenu.Profile),
        NavigationItem(title = "Appointments", icon = Icons.Filled.Approval, route = RouteMenu.Appointments),
        NavigationItem(title = "History", icon = Icons.Default.Person, route = RouteMenu.History),
        NavigationItem(title = "Settings", icon = Icons.Default.Person, route = RouteMenu.Setting),


        )

}
