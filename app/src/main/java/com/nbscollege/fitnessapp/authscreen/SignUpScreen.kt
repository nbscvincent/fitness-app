package com.example.example.model

//import com.nbscollege.fitnessapp.authscreen.model.account

import Auth
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.rounded.Height
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.MonitorWeight
import androidx.compose.material.icons.rounded.PlusOne
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
import com.nbscollege.fitnessapp.dialog.AlertDialogExample
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.RegistrationViewModel
import com.nbscollege.fitnessapp.ui.user.UserDetails
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController, viewModel: RegistrationViewModel = viewModel(factory = AppViewModelProvider.Factory)) {

    val coroutineScope = rememberCoroutineScope()


    var id by remember { mutableIntStateOf(0) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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

    var age by remember { mutableStateOf("") }
    var ageError by remember { mutableStateOf(false) }



    val context = LocalContext.current
    var confirmPasswordColor =
        if (confirmPassword.isEmpty()) Color.Transparent
        else if (password == confirmPassword) Color.Green
        else Color.Red

    val darkGreen = colorResource(id = R.color.DarkGreen)


    if (openAlertDialog.value) {
        AlertDialogExample(
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                openAlertDialog.value = false
                userError = false
                passwordError = false
                weightError = false
                heightError = false
                confirmPasswordError = false
                ageError = false

                coroutineScope.launch {
                    var userUiState = viewModel.userUiState

                    userUiState.userDetails = UserDetails(
                        username = username,
                        password = password,
                        height = height.toFloatOrNull()!!,
                        weight = weight.toFloatOrNull()!!,
                        age = age.toInt()
                    )

                    viewModel.saveUser()
                    Log.i("userUiState", userUiState.userDetails.toString())

                }

                // Add the new user to the list of registered users
                registeredUsers.add(User(id, username, password,
                    weight.toFloatOrNull()!!, height.toFloatOrNull()!!, age.toInt()))
                navController.navigate(Auth.LogInScreen.name) // Add logic here to handle confirmation.


            },
            dialogTitle = "Do you really want to create an account?",
            icon = Icons.Rounded.Info,
        )
    }


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.fitness_logo),
                contentDescription = "Fitness LOGO"
            )
            Text(
                "Register an account",
                fontWeight = FontWeight.Medium,
                style = TextStyle(fontSize = 25.sp, color = Color.Black)
            )
            Text(
                "Fill out the following details to create a new a account",
                fontWeight = FontWeight.Medium,
                style = TextStyle(fontSize = 18.sp, color = Color.Gray, textAlign = TextAlign.Center)
            )
            Box(Modifier.height(25.dp))
            TextField(
                isError = userError,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                label = { Text("Username" , fontWeight = FontWeight.Medium) },
                value = username,
                onValueChange = {
                    username = it

                },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "newUsername"
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

                label = { Text("Password" , fontWeight = FontWeight.Medium) },
                value = password,
                onValueChange = { password = it },
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
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent

                ),

            )
            TextField(
                isError = confirmPasswordError,
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp)
                    .border(1.dp, color = confirmPasswordColor, shape = RoundedCornerShape(16.dp)
                    ),

                label = { Text("Confirm Password" , fontWeight = FontWeight.Medium) },
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
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                )
                )

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly

                    ) {
                        TextField(
                            isError = weightError,
                            modifier = Modifier.width(200.dp)
                                .absolutePadding(left = 40.dp, bottom = 11.dp),
                            label = { Text("Weight(lb)" , fontWeight = FontWeight.Medium) },
                            value = weight,
                            onValueChange = { weight = it },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            trailingIcon = {
                                Icon(
                                    Icons.Rounded.MonitorWeight,
                                    contentDescription = "Weight"
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
                            isError = heightError,
                            modifier = Modifier.
                                width(300.dp)
                                .clip(CircleShape)
                                .absolutePadding(left = 15.dp, bottom = 11.dp, right = 40.dp),
                            label = { Text("Height(cm)" , fontWeight = FontWeight.Medium) },
                            value = height,
                            onValueChange = { height = it },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            trailingIcon = {
                                Icon(
                                    Icons.Rounded.Height,
                                    contentDescription = "height"
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
                    }

                }
            
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.padding(end=225.dp)
            ) {
                TextField(
                    isError = ageError,
                    modifier = Modifier.width(200.dp)
                        .absolutePadding(left = 40.dp, bottom = 11.dp),
                    label = { Text("Age" , fontWeight = FontWeight.Medium) },
                    value = age,
                    onValueChange = { age = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    trailingIcon = {
                        Icon(
                            Icons.Rounded.PlusOne,
                            contentDescription = "Age"
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
//                TextField(
//                    modifier = Modifier.
//                    width(300.dp)
//                        .clip(CircleShape)
//                        .absolutePadding(left = 15.dp, bottom = 11.dp, right = 40.dp),
//                    label = { Text("Gender") },
//                    value = height,
//                    onValueChange = { height = it },
//                    singleLine = true,
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    trailingIcon = {
//                        Icon(
//                            Icons.Rounded.Transgender,
//                            contentDescription = "height"
//                        )
//                    },
//                    shape = RoundedCornerShape(12.dp),
//                    colors = TextFieldDefaults.textFieldColors(
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        errorIndicatorColor = Color.Transparent
//                    )
//                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Button(
                    onClick = {
//                        coroutineScope.launch {
//                            var userUiState = viewModel.userUiState
//                            userUiState.userDetails
//                                UserDetails(username = username, password = password)
//                            viewModel.saveUser()
//                            Log.i("userUiState", userUiState.userDetails.toString())
//                        }
                        if (username.isNotEmpty() && password.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty() && confirmPassword.isNotEmpty()  && age.isNotEmpty() && password == confirmPassword) {
                            // Check if the username is already taken
                            if (registeredUsers.any { it.username == username}) {
                                userError = true
                                passwordError = false
                                weightError = false
                                heightError = false
                                ageError = false



                                Toast.makeText(context, "Username already Taken!", Toast.LENGTH_SHORT).show()
                            }
                            else {
                                openAlertDialog.value = true
                            }
                        }



                        else if (confirmPassword != password) {
                            Toast.makeText(context, "password does not match", Toast.LENGTH_SHORT).show()
                        }
                        else {
                                userError = username.isEmpty()
                                passwordError = password.isEmpty()
                                weightError = weight.isEmpty()
                                heightError = height.isEmpty()
                                confirmPasswordError = confirmPassword.isEmpty()
                                ageError = age.isEmpty()

                            Toast.makeText(context, "Please fill the registration!", Toast.LENGTH_SHORT).show()
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
                    shape = RoundedCornerShape(12.dp),

                ) {
                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Register", fontSize = 19.sp,fontWeight = FontWeight.Medium, modifier = Modifier.padding(1.dp))
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(11.dp, bottom = 65.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Already a member?", fontSize = 16.sp , fontWeight = FontWeight.Medium)
                        Box(Modifier.width(7.dp))
                            Text("Login here", fontSize = 16.sp, color = Color.Red,fontWeight = FontWeight.Medium,modifier = Modifier.clickable( onClick = {
                                navController.navigate(Auth.LogInScreen.name)
                            }, ) )

                    }
                }
            }
        }
    }
}





