package com.example.example.model

//import com.nbscollege.fitnessapp.authscreen.model.account
import Auth
import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.Routes
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginState
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, screenViewModel: ScreenViewModel, viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }

    val _isProgressVisible = MutableStateFlow(false)
    val isProgressVisible: StateFlow<Boolean> = _isProgressVisible.asStateFlow()

    var isLoginSuccessful by remember { mutableStateOf(false) }

    val context = LocalContext.current

    var userError by remember {
        mutableStateOf(false)
    }
    var passwordError by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()



    // Observe the showToast state and show a toast when it changes




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
                fontWeight = FontWeight.Medium,
                style = TextStyle(fontSize = 25.sp, color = Color.Black)
            )
            Text(
                "sign in to access your account",
                fontWeight = FontWeight.Medium,
                style = TextStyle(fontSize = 18.sp, color = Color.Gray)
            )
            Box(Modifier.height(25.dp))
            TextField(
                isError = userError,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .absolutePadding(left = 40.dp, right = 40.dp, bottom = 11.dp),
                label = { Text("Username", fontWeight = FontWeight.Medium) },
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

                label = { Text("Password", fontWeight = FontWeight.Medium) },
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
                Text(text = "Forgot Password?", color = Color.Red, fontWeight = FontWeight.Medium, modifier = Modifier.clickable( onClick = {
                    navController.navigate(Auth.OTP.name)
                }, ) )
            }



            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = {

                if (password.isNotEmpty() && username.isNotEmpty()) {

                                // Authentication successful

                                // Update the state to reflect the login success
//                                screenViewModel.loginUser(username, password)



                    coroutineScope.launch {
                        // Assuming viewModel is an instance of LoginViewModel
                        viewModel.login(username,password)

                        // Observe the loginState to get the updated state after the login function
                        viewModel.loginState.collect { loginState ->
                            when (loginState) {
                                is LoginState.Success -> {
                                    // Handle successful login
                                    val user = loginState.user
                                    Log.i("LoginState", "Success: ${user.username}")
                                    Toast.makeText(context, "Welcome $username!", Toast.LENGTH_SHORT)
                                        .show()
                                    navController.navigate(Routes.MAIN.name)
                                }
                                is LoginState.Error -> {
                                    // Handle login error

                                    val error = loginState.error
                                    Log.i("LoginState", "Error: $error")
                                    Toast.makeText(context,"Error: $error", Toast.LENGTH_SHORT).show()
                                    // Handle the error, for example, display an error message to the user
                                }
                                else -> {

                                }
                            }
                        }
                    }


                        }
                        else {

                            if(password.isEmpty() && username.isEmpty()){
                                userError = username.isEmpty()
                                passwordError = password.isEmpty()

                                Toast.makeText(
                                    context,
                                    "Please input your username and password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else if(username.isEmpty()) {
                                userError = username.isEmpty()
                                Toast.makeText(
                                    context,
                                    "Please input username",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else if (password.isEmpty()) {
                                passwordError = password.isEmpty()
                                Toast.makeText(
                                    context,
                                    "Please input password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }




                    }
                    ,
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
                        Text("Login", fontSize = 19.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(1.dp))
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
                        Text("New Member?", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                        Box(Modifier.width(7.dp))
                        TextButton(onClick = { navController.navigate(Auth.SignUpScreen.name) }) {
                            Text("Register here", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }



    }
}










           
        

        
