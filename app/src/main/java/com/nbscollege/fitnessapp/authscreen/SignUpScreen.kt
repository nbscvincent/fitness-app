package com.example.example.model

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.rounded.MonitorWeight
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
//import com.nbscollege.fitnessapp.authscreen.model.account
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.rememberCoroutineScope
import com.nbscollege.fitnessapp.authscreen.model.User

import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var newUsername by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }
    var confirmShowPassword by remember {
        mutableStateOf(false)
    }
    var confirmPasswordError by remember { mutableStateOf(false) }

    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    val openAlertDialog = remember { mutableStateOf(false) }

    var userError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var weightError by remember { mutableStateOf(false) }
    var heightError by remember { mutableStateOf(false) }


    val context = LocalContext.current
    var confirmPasswordColor = if (newPassword == confirmPassword) Color.Green else Color.Red



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
                value = newUsername,
                onValueChange = { newUsername = it },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "newUsername"
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
                value = newPassword,
                onValueChange = { newPassword = it },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { showPassword = showPassword != true }) {
                        Icon(
                            if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "newPassword"
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
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),

                label = { Text("Confirm Password") },
                value = confirmPassword,
                onValueChange = { confirmPassword = it
                                },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { confirmShowPassword = confirmShowPassword != true }) {
                        Icon(
                            if (confirmShowPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "confirmPassword",

                        )
                    }
                },
                visualTransformation = if (confirmShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    textColor = Color.Black,


                ),


                )




                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly

                    ) {
                        TextField(
                            modifier = Modifier.width(200.dp)
                                .absolutePadding(left = 40.dp, bottom = 11.dp),
                            label = { Text("Weight") },
                            value = weight,
                            onValueChange = { weight = it },
                            singleLine = true,
//                            trailingIcon = {
//                                Icon(
//                                    Icons.Rounded.,
//                                    contentDescription = "Weight"
//                                )
//                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            )
                        )
                        TextField(
                            modifier = Modifier.
                                width(300.dp)
                                .clip(CircleShape)
                                .absolutePadding(left = 15.dp, bottom = 11.dp, right = 40.dp),
                            label = { Text("Height") },
                            value = height,
                            onValueChange = { height = it },
                            singleLine = true,
//                            trailingIcon = {
//                                Icon(
//                                    Icons.Rounded.Email,
//                                    contentDescription = "height"
//                                )
//                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
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
                        if (newUsername.isNotEmpty() && newPassword.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty() && confirmPassword.isNotEmpty() && newPassword == confirmPassword) {
                            // Check if the username is already taken
                            if (registeredUsers.any { it.username == newUsername}) {
                                userError = true
                                passwordError = false
                                weightError = false
                                heightError = false

                            }
                            else {
                                userError = false
                                passwordError = false
                                weightError = false
                                heightError = false


                                // Add the new user to the list of registered users
                                registeredUsers.add(User(newUsername, newPassword, weight, height))

                                // Provide feedback to the user
                                Toast.makeText(context, "Signup successful!", Toast.LENGTH_SHORT).show()

                                // Optionally, navigate to the login screen after signup
                                navController.navigate(Auth.LogInScreen.name)
                            }
                        }


                        // Display error message if passwords do not match

                        else {
                            if (confirmPasswordError) {
                                Toast.makeText(context, "password does not match", Toast.LENGTH_SHORT).show()
                            }
                            else {


                                userError = newUsername.isEmpty()
                                passwordError = newPassword.isEmpty()
                                weightError = weight.isEmpty()
                                heightError = height.isEmpty()
                                confirmPasswordError = confirmPassword.isNotEmpty()
                                Toast.makeText(
                                    context,
                                    "Please fill the registration!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }




//                        openAlertDialog.value = true
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





