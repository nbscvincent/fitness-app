package com.example.example.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.dialog.AlertDialogExample
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }
    val openAlertDialog = remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.fitness_logo),
                contentDescription = "NBS LOGO"
            )
            Text(
                "Register an account",
                style = TextStyle(fontSize = 25.sp, color = Color.Black)
            )
            Text(
                "Fill out the following details to create a new a account",
                style = TextStyle(fontSize = 18.sp, color = Color.Gray, textAlign = TextAlign.Center)
            )
            Box(Modifier.height(25.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                label = { Text("Username") },
                value = username,
                onValueChange = { username = it },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Username"
                    )
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),

                label = { Text("Password") },
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { showPassword = showPassword != true }) {
                        Icon(
                            if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Password"
                        )
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),

            )
            Column(

            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape)
                            .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                        label = { Text("Weight") },
                        value = username,
                        onValueChange = { username = it },
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                Icons.Rounded.Email,
                                contentDescription = "Weight"
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape)
                            .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                        label = { Text("Height") },
                        value = username,
                        onValueChange = { username = it },
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                Icons.Rounded.Email,
                                contentDescription = "Height"
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }
            }



            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {

                        openAlertDialog.value = true
                    },
                    modifier = Modifier
                        .absolutePadding(
                            left = 40.dp,
                            right = 40.dp,
                            bottom = 25.dp,
                            top = 25.dp
                        )
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Register", fontSize = 19.sp, modifier = Modifier.padding(1.dp))
                    }
                    when {
                        // ...
                        openAlertDialog.value -> {
                            AlertDialogExample(
                                onDismissRequest = { openAlertDialog.value = false },
                                onConfirmation = {
                                    openAlertDialog.value = false
                                    println("Confirmation registered") // Add logic here to handle confirmation.
                                },
                                dialogTitle = "You Successfully Created an Account",
                                dialogText = "",
                                icon = Icons.Default.Info
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(11.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Already a member?", fontSize = 16.sp)
                        Box(Modifier.width(7.dp))
                        TextButton(onClick = { navController.navigate(Auth.LogInScreen.name) }) {
                            Text("Login now", fontSize = 16.sp, color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}





