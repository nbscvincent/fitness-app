package com.example.example.model

import Auth
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.authscreen.AuthenticationScreen
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
//import com.nbscollege.fitnessapp.authscreen.model.account
import com.nbscollege.fitnessapp.navigation.Routes
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.util.StringUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController ) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }

    var isLoginSuccessful by remember { mutableStateOf(false) }

    val context = LocalContext.current

    var userError by remember {
        mutableStateOf(false)
    }
    var passwordError by remember {
        mutableStateOf(false)
    }


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
                "Welcome back",
                style = TextStyle(fontSize = 25.sp, color = Color.Black)
            )
            Text(
                "sign in to access your account",
                style = TextStyle(fontSize = 18.sp, color = Color.Gray)
            )
            Box(Modifier.height(25.dp))
            TextField(
                isError = userError,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                label = { Text("Username") },
                value = username,
                singleLine = true,
                onValueChange = { username = it },
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Username"
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )
            TextField(
                isError = passwordError,
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
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )

            Column(
                modifier = Modifier.padding(start=220.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Forgot Password?", color = Color.Red, modifier = Modifier.clickable( onClick = {
                    navController.navigate(Auth.OTP.name)
                }, ) )
            }



            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
//                        if (StringUtil().isEmptyString(username)) {
//                            userError = true
//                            return@Button
//                        }
//                        if (StringUtil().isEmptyString(password)) {
//                            passwordError = true
//                            return@Button
//                        }

                        if (password.isNotEmpty() && username.isNotEmpty()) {
                            if (registeredUsers.any { it.username == username && it.password == password }) {
                                // Authentication successful
                                Toast.makeText(context, "Welcome $username!", Toast.LENGTH_SHORT)
                                    .show()
                                // Update the state to reflect the login success
                                navController.navigate(Routes.MAIN.name)
                            } else {
                                // Authentication failed
                                Toast.makeText(
                                    context,
                                    "Incorrect username or password.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        else {


                                userError = username.isEmpty()
                                passwordError = password.isEmpty()

                                Toast.makeText(
                                    context,
                                    "Please fill the registration!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            
                        }


                    },
                    modifier = Modifier
                        .absolutePadding(
                            left = 40.dp,
                            right = 40.dp,
                            bottom = 25.dp,
                            top = 25.dp
                        )
                        .fillMaxWidth(),

                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Login", fontSize = 19.sp, modifier = Modifier.padding(1.dp))
                    }
                }
//                if (isLoginSuccessful) {
//                    Text("Login successful!", color = Color.Green)
//                } else {
//                    Text("Login failed. Please try again.", color = Color.Red)
//                }
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
                        Text("New Member?", fontSize = 16.sp)
                        Box(Modifier.width(7.dp))
                        TextButton(onClick = { navController.navigate(Auth.SignUpScreen.name) }) {
                            Text("Register here", fontSize = 16.sp, color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}










           
        

        
