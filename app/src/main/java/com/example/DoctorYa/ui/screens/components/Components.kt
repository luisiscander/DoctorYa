package com.example.DoctorYa.ui.screens.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

enum class Type{

    User,Password
}

@Composable
fun CmpTextField (value: String,
                  placeholder: @Composable (()->Unit)?=null,
                  leading: @Composable  (()-> Unit)?=null,
                  trailing: @Composable (()-> Unit)?=null,
                  type: Type?=null,
                  onChange:(String)-> Unit)
{


    OutlinedTextField(onValueChange = {onChange(it)} ,
        value = value,
        singleLine = true,
        placeholder= {
            when(type) {
                Type.User -> { Text(text = "username") }
                Type.Password -> { Text(text = "password") }
                null -> {placeholder}
            }
        },
        leadingIcon = {
            if(leading==null) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "" )
        } else leading()},
        trailingIcon = trailing,
        visualTransformation = if(type== Type.Password) PasswordVisualTransformation()  else{ VisualTransformation.None}



         )

}


@Composable
fun CmpButton(onClick:()-> Unit) {

    OutlinedButton(onClick = {onClick()}, modifier = Modifier.fillMaxWidth().padding(horizontal = 54.dp)) {
        Text("Login")
    }

}