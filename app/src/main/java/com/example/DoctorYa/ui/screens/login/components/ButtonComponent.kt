package com.example.DoctorYa.ui.screens.login.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(enable: Boolean ?, @DrawableRes image: Int? =null, onClick:()-> Unit) {

    OutlinedButton(onClick = {onClick()},
        enabled = enable?: true,

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 70.dp)) {
        if (image!=null){
            Icon(painter = painterResource(image), contentDescription = "")
            Spacer(modifier = Modifier.width(4.dp))
        }

        Text("Login")
    }

}