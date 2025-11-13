package com.example.DoctorYa.utils.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator

import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.DoctorYa.ui.screens.home.HomeScreen

import com.example.DoctorYa.ui.screens.login.LoginScreen

import com.example.DoctorYa.ui.screens.onboarding.OnBoardingScreen
import com.example.DoctorYa.ui.screens.save.SaveScreen
import kotlinx.serialization.Serializable




@Serializable
sealed interface Routes: NavKey{
    @Serializable
    data object Login: Routes
    @Serializable
    data object  Home: Routes
    @Serializable
    data object  Home2: Routes
    @Serializable
    data class  Detail(val id:Int): Routes
    @Serializable
    data object Save: Routes
    @Serializable
    data object OnBoardingScreen : Routes


}


@Composable
fun Navigation(){

    val backStack= rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack =backStack,
        entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator(), rememberViewModelStoreNavEntryDecorator() ) ,
        entryProvider = entryProvider {



            entry<Routes.OnBoardingScreen>{ OnBoardingScreen(){ backStack.add(Routes.Login)}  }

            entry <Routes.Login>{ LoginScreen(){backStack.add(Routes.Home)} }


            entry<Routes.Home> { HomeScreen() }


            entry<Routes.Save>{  SaveScreen()  }



        })








}