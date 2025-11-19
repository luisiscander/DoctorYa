package com.example.DoctorYa.ui.screens.login.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource


enum class Type{

    User,Password
}

@Composable
fun TextFieldComponent (type: Type?=null,
                  value: String,
                  isError: Boolean=false,
                  label: @Composable (()->Unit)?=null,
                  placeHolder: @Composable (()->Unit)?=null,
                  leadingIcon:@Composable (()->Unit)?=null,
                  trailingIcon:@Composable (()->Unit)?=null,
                  keyboardOptions: KeyboardOptions? = null,
                  keyboardActions: KeyboardActions? = null,
                  onChange:(String)-> Unit
)
{
    val focus= LocalFocusManager.current
    var visibility by remember { mutableStateOf(false)  }


    OutlinedTextField(onValueChange = {onChange(it)} ,
        value = value,
        singleLine = true,
        isError = isError,
        keyboardOptions = keyboardOptions ?:
            KeyboardOptions(
            keyboardType = if (type== Type.User) KeyboardType.Email else KeyboardType.Password,
             imeAction = if (type== Type.User) ImeAction.Next else ImeAction.Done
            ) ,
        keyboardActions = keyboardActions?: KeyboardActions(
            onNext = {focus.moveFocus(FocusDirection.Next)},
            onDone = {focus.clearFocus()}

        ),

        shape = RoundedCornerShape(16.dp),
        label = {
            when(type) {
                Type.User -> {Text(text = "user name")}
                Type.Password -> {Text("password")}
                null -> {label}
            }
        },
        placeholder= {
            when(type) {
                Type.User -> { Text(text = "enter username") }
                Type.Password -> { Text(text = "enter password") }
                null -> {placeHolder}
            }
        },
        leadingIcon = {
              if (type!=null){
            var icon: ImageVector = when(type) {
                Type.User -> Icons.Default.Person
                Type.Password -> Icons.Default.Lock
            }
                  Icon(imageVector =icon, contentDescription = "" )
            }else{ leadingIcon }
           

                      },
        trailingIcon = {

            var icon=  if(visibility) Icons.Default.Visibility else Icons.Default.VisibilityOff
             if (type==Type.Password)
            Icon(imageVector = icon, contentDescription = "", modifier = Modifier.clickable{visibility=!visibility})
            else {trailingIcon}
        },
        visualTransformation = if(type== Type.Password && !visibility) PasswordVisualTransformation()  else{ VisualTransformation.None}



         )

}



