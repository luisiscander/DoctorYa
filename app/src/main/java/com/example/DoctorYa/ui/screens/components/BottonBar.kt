package com.example.DoctorYa.ui.screens.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import com.example.DoctorYa.ui.screens.home.model.NavigationItem
import com.example.DoctorYa.ui.screens.home.model.getNavigationItems
import com.example.DoctorYa.utils.navigation.RouteMenu

@Composable
fun BottonBarComponent(
     /*selected: Int,*/
  currentRoute: NavKey?,
     onClick:(NavKey)-> Unit) {

    BottomAppBar {

        getNavigationItems().forEachIndexed { index, item ->

            NavigationBarItem(
                onClick = { onClick(item.route) },
                icon = { Icon(imageVector = item.icon, contentDescription ="") },
                selected = /*selected == index,*/ item.route == currentRoute,
               label = { Text(text = item.title) }
                )

        }

    }




}