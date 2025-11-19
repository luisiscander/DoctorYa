package com.example.DoctorYa.utils.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.DoctorYa.ui.screens.appointment.AppointmentScreen
import com.example.DoctorYa.ui.screens.history.HistoryScreen
import com.example.DoctorYa.ui.screens.profile.ProfileScreen
import com.example.DoctorYa.ui.screens.setting.SettingScreen
import kotlinx.serialization.Serializable


sealed interface RouteMenu : NavKey {

    @Serializable
    data object Profile : RouteMenu

    @Serializable
    data object Appointments : RouteMenu

    @Serializable
    data object History : RouteMenu

    @Serializable
    data object Setting : RouteMenu

}


@Composable
fun NavigationMenu(
    modifier: Modifier = Modifier,
    backStack:NavBackStack<NavKey>

) {
   // val backStack = rememberNavBackStack(RouteMenu.Appointments)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()

        ),
        entryProvider = entryProvider{

            entry<RouteMenu.Appointments> { AppointmentScreen() }
            entry<RouteMenu.Profile> { ProfileScreen() }
            entry<RouteMenu.History> { HistoryScreen() }
            entry<RouteMenu.Setting> { SettingScreen() }

        }


    )
}