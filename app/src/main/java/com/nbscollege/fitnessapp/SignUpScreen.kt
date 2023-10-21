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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nbscollege.fitnessapp.R


class SignUpScreen {


    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    @Composable
    fun SignUp() {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var agree by remember { mutableStateOf(false) }
        var passwordVisibility by remember { mutableStateOf(false) }
        val roundedCornerShape: Shape = RoundedCornerShape(16.dp)
        val keyboardController = LocalSoftwareKeyboardController.current

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
                    .padding(),
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
                        modifier = Modifier.size(40.dp)
                    )
                }

            }

            Image(
                painter = painterResource(id = R.drawable.fitnesslogo), // Replace with your image resource
                contentDescription = null, // Provide a content description
                modifier = Modifier
                    .size(width = 250.dp, height = 200.dp)
                    .align(Alignment.CenterHorizontally)

            )

            Text(
                text = "Hey There,",
                color = Color.Black, fontSize = 21.sp
            )
            Text(
                text = "Create an Account",
                color = Color.Black,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(40.dp)) // Add vertical spa
            TextField(
                value = name,
                onValueChange = {
                    name = it
                },


                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                label = { Text("Full name", color = Color.Gray) },
                trailingIcon = {
                    Icon(
                        Icons.Default.Person, contentDescription = "Contact icon",
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
                value = email,
                onValueChange = {
                    email = it
                },


                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                label = { Text("Password", color = Color.Gray) },
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
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),


                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                label = { Text("Weight", color = Color.Gray) },
                trailingIcon = {
                    Icon(
                        Icons.Default.Phone, contentDescription = "Password lock icon",
                        modifier = Modifier.graphicsLayer(alpha = 0.5f)
                    ) // Add lock icon here
                },
                singleLine = true,
                shape = roundedCornerShape,
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp), colors = textFieldColors

            )
            Spacer(modifier = Modifier.height(15.dp)) // Add vertical space

            TextField(
                value = password,
                onValueChange = {
                    password = it
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),

                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                label = { Text("Height", color = Color.Gray) },
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
                    .padding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp) // Adjust the size here
                        .clip(MaterialTheme.shapes.extraSmall)
                ) {

                    Checkbox(modifier = Modifier.padding(start = 5.dp),

                        checked = agree,
                        onCheckedChange = { checked ->
                            agree = checked
                        }
                    )
                }
                // "Terms and Conditions" Button
                Text(
                    text = "By continuing you accept the",
                    fontSize = 9.sp,
                    color = Color.Black
                )

                TextButton(
                    onClick = {
                        // Handle "Terms and Conditions" button click
                    }
                ) {
                    Text("Privacy Policy", color = Color.Blue, fontSize = 9.sp)
                }

                Text(
                    text = "and",
                    fontSize = 9.sp,
                    color = Color.Black
                )

                TextButton(
                    onClick = {
                        // Handle "Conditions" button click
                    }
                ) {
                    Text("Terms of Use.", color = Color.Blue, fontSize = 9.sp)
                }
            }


            Column(
                modifier = Modifier.fillMaxSize()
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .background(Color.White), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                        .padding(end = 30.dp)
                        .background(
                            Color.Blue,
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
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = Color.White
                            )
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    text = "Register",
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
                                text = "Already a member?",
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding()
                            )

                            Text(
                                text = "Log in",
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

    fun Text(color: Color, modifier: Modifier) {

    }
}

private fun Alignment.clickable(function: () -> Unit) {

}

