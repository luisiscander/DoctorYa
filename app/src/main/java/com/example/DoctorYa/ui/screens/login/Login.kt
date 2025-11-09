package com.example.DoctorYa.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.DoctorYa.R
import com.example.DoctorYa.ui.screens.components.CmpButton
import com.example.DoctorYa.ui.screens.components.CmpTextField
import com.example.DoctorYa.ui.screens.components.Type

@Composable
fun Login() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //header
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1.5f), contentAlignment = Alignment.Center)
        {
            Image(
                painter = painterResource(R.drawable.ic_person), contentDescription = "profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize(0.5f)
            )

        }

        //body
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Card(modifier = Modifier.fillMaxSize(),
                elevation = CardDefaults.cardElevation(2.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(width = 1.dp, color = Color.Transparent)
                ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Center){
                    CmpTextField( type = Type.User, value = user,){user = it}

                    Spacer(modifier = Modifier.height(10.dp))

                    CmpTextField(type = Type.Password, value = password,) {password=it}

                    Spacer(modifier = Modifier.height(16.dp))

                    CmpButton(){}
                }

            }

        }

        //footer
        Row(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                "CopyRight@2025",
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium)
            )
        }


    }

}

@Preview(showSystemUi = true)
@Composable
private fun LoginPreview() {
    Login()

}