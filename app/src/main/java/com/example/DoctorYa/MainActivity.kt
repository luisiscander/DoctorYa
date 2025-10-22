package com.example.DoctorYa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.DoctorYa.ui.screens.home.Home
import com.example.DoctorYa.ui.screens.save.SaveScreen
import com.example.DoctorYa.ui.theme.TemplateCodeTheme
import com.example.DoctorYa.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemplateCodeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Navigation()

                }
            }
        }
    }
}

