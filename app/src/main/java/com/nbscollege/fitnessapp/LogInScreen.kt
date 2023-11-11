package com.example.example.model

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nbscollege.fitnessapp.R


class LogInScreen {


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login() {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var rememberMe by remember { mutableStateOf(false) }
        var passwordVisibility by remember { mutableStateOf(false) }
        val roundedCornerShape: Shape = RoundedCornerShape(16.dp)

        val textFieldColors = TextFieldDefaults.textFieldColors(

            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,

            )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Back icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Back icon
                IconButton(
                    onClick = {
                        // Handle back button click here
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.Gray,
                        modifier = Modifier.size(32.dp)
                    )
                }

            }

            Image(
                painter = painterResource(R.drawable.fitnesslogo),
                contentDescription = null, // Provide a content description
                modifier = Modifier
                    .size(width = 200.dp, height = 150.dp)
                    .align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(10.dp)) // Add vertical spa


            Text(
                text = "Log in",
                color = Color.Black, fontSize = 18.sp
            )
            Text(
                text = "Welcome Back",
                color = Color.Black,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(75.dp)) // Add vertical spa
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },


                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                label = { Text("Email", color = Color.Gray) },
                trailingIcon = {
                    Icon(
                        Icons.Default.Email, contentDescription = "Email icon",
                        modifier = Modifier.graphicsLayer(alpha = 0.5f)
                    ) // Add email icon here
                },
                singleLine = true,
                shape = roundedCornerShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                colors = textFieldColors,


                )

            Spacer(modifier = Modifier.height(15.dp)) // Add vertical space


            TextField(
                value = password,
                onValueChange = {
                    password = it
                },


                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                label = { Text("Password", color = Color.Gray) },
                trailingIcon = {
                    Icon(
                        Icons.Default.Lock, contentDescription = "Password lock icon",
                        modifier = Modifier.graphicsLayer(alpha = 0.5f)
                    ) // Add lock icon here
                },
                singleLine = true,
                shape = roundedCornerShape,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp), colors = textFieldColors

            )



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Remember Me Checkbox

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(50.dp) // Adjust the size here
                            .clip(MaterialTheme.shapes.extraSmall)
                    ) {

                        Checkbox(modifier = Modifier.padding(start = 30.dp),

                            checked = rememberMe,
                            onCheckedChange = { checked ->
                                rememberMe = checked
                            }
                        )
                    }

                    Text(
                        text = "Remember Me",
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp),

                        )

                    TextButton(
                        modifier = Modifier.padding(start = 160.dp),
                        onClick = { },

                        ) {
                        Text("Forgot your Password? ", color = Color.Blue, fontSize = 12.sp)
                    }
                }


            }


            Column(
                modifier = Modifier.fillMaxSize()
                    .fillMaxWidth()
                    .padding(top = 130.dp)
                    .background(Color.White), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                        .padding(end = 30.dp)
                        .background(
                            Color.Red,
                            shape = MaterialTheme.shapes.medium
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                // Handle the click event for the red background here
                            }
                    ) {

                        TextButton(
                            onClick = {
                                // "Next" TextButton click action
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color.Blue, // Change background color to red
                                    shape = RoundedCornerShape(16.dp) // Rounded corners
                                ),
                            // Adjust padding here
                            colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {


                                Text(
                                    text = "Login",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null, // Add a description if needed
                                    tint = Color.White, // Change the arrow color
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(),
                    // Add vertical scroll if needed
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Remember Me Checkbox
                    Row(
                        modifier = Modifier.padding(top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't have account yet?",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding()
                        )

                        Text(
                            text = "Register",
                            color = Color.Blue,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .clickable { /* Handle Register Now Text Click */ }
                                .padding(start = 5.dp)
                        )
                    }
                }
            }
        }
    }


    }







           
        

        
