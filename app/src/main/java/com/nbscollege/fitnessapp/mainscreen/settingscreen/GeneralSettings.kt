package com.nbscollege.fitnessapp.mainscreen.settingscreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import kotlinx.coroutines.launch


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun GeneralSettings(navController: NavController, backStackEntry: NavBackStackEntry, viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)) {

    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Dialog state
    var showDialogConfirmation by remember { mutableStateOf(false) }

    var confirmPasswordColor =
        if (!viewModel.oldPasswordCorrect) Color.Red
        else Color.Black

    var currentPasswordError by remember { mutableStateOf(false) }
    var newPasswordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }

    var showCurrent by remember {
        mutableStateOf(false)
    }
    var showNew by remember {
        mutableStateOf(false)
    }
    var showConfirm by remember {
        mutableStateOf(false)
    }





    Scaffold(
        topBar = {

            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Change Password",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
                )

            }

        },
        bottomBar = {
//            BottomAppBar {
//
//            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Text("Current Password", modifier = Modifier.absolutePadding(left = 10.dp, bottom = 5.dp))

            OutlinedTextField(

                modifier = Modifier
                    .absolutePadding(left = 20.dp, bottom = 11.dp),
                isError = currentPasswordError,

                label = { Text("Current Password", fontWeight = FontWeight.Medium) },
                value = currentPassword,
                singleLine = true,
                onValueChange = { currentPassword = it },
                trailingIcon = {

                    IconButton(onClick = { showCurrent = showCurrent != true }) {
                        Icon(
                            if (showCurrent) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "currentPassword"
                        )
                    }

                },
                visualTransformation = if (showCurrent) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(12.dp),

            )
            if (!viewModel.oldPasswordCorrect) {
                Text("Current password is incorrect", color = Color.Red)
            } else {
                Text("")
            }



            Spacer(modifier = Modifier.height(20.dp))

            Text("New Password", modifier = Modifier.absolutePadding(left = 10.dp, bottom = 5.dp))

            OutlinedTextField(

                modifier = Modifier.absolutePadding(left = 20.dp, bottom = 11.dp),
                isError = newPasswordError,
                label = { Text("New Password", fontWeight = FontWeight.Medium) },
                value = newPassword,
                singleLine = true,
                onValueChange = { newPassword = it },
                trailingIcon = {
                    IconButton(onClick = { showNew = showNew != true }) {
                        Icon(
                            if (showNew) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "currentPassword"
                        )
                    }
                },
                visualTransformation = if (showNew) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(12.dp),

                )


            Spacer(modifier = Modifier.height(20.dp))

            Text("Confirm New Password", modifier = Modifier.absolutePadding(left = 10.dp, bottom = 5.dp))

            OutlinedTextField(

                modifier = Modifier
                    .absolutePadding(left = 20.dp, bottom = 11.dp),
                isError = confirmPasswordError,
                label = { Text("Confirm Password", fontWeight = FontWeight.Medium) },
                value = confirmPassword,
                singleLine = true,
                onValueChange = { confirmPassword = it },
                trailingIcon = {
                    IconButton(onClick = { showConfirm = showConfirm != true }) {
                        Icon(
                            if (showConfirm) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "confirm password"
                        )
                    }
                },
                visualTransformation = if (showConfirm) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(12.dp),

                )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
               onClick = {


                   coroutineScope.launch {
                       if (currentPassword.isNotEmpty() && newPassword.isNotEmpty()  && confirmPassword.isNotEmpty() &&
                           newPassword == confirmPassword
                               ) {
                           // Call your ViewModel function to change the password
//                           viewModel.changePassword(currentPassword, newPassword, navController)
//                           viewModel.status = false
//                           val prefer = context.getSharedPreferences("prefs", 0)
//                           prefer.edit()
//                               .clear()
//                               .apply()
                           if(newPassword == currentPassword && viewModel.oldPasswordCorrect) {
                               Toast.makeText(context,"password is the same with the current password, Please try again", Toast.LENGTH_SHORT).show()
                           }

                           else {
                               showDialogConfirmation = true
                           }




                       }
//                       else if (newPassword.isEmpty() && currentPassword.isEmpty()) {
//                           currentPasswordError = currentPassword.isEmpty()
//                           newPasswordError = newPassword.isEmpty()
//                           confirmPasswordError = confirmPassword.isEmpty()
//
//                           Toast.makeText(context,"Pleas fill the text-field", Toast.LENGTH_SHORT).show()
//
//                       }
                       else if (newPassword != confirmPassword){
                           Toast.makeText(context,"please input the same password", Toast.LENGTH_SHORT).show()

                       }
                       else {
                           currentPasswordError = currentPassword.isEmpty()
                           newPasswordError = newPassword.isEmpty()
                           confirmPasswordError = confirmPassword.isEmpty()
                           Toast.makeText(context,"Pleas fill the text-field", Toast.LENGTH_SHORT).show()
                       }

                   }



               } // end of onclick button
            ) {
                Text("Change Password")
            }



            if (showDialogConfirmation) {
                AlertDialog(

                    onDismissRequest = {
                        showDialogConfirmation = false
                    },
                    title = {
                        Text("Change Password", textAlign = TextAlign.Center)
                    },
                    text = {
                        Text("Are you sure you want to change the password?", textAlign = TextAlign.Center)
                    },
                    confirmButton = {
                        Button(
                            onClick = {

                                // Call your ViewModel function to change the password
                                viewModel.changePassword(currentPassword, newPassword, navController)
                                viewModel.status = false
                                val prefer = context.getSharedPreferences("prefs", 0)
                                prefer.edit()
                                    .clear()
                                    .apply()
                                showDialogConfirmation = false

                            }
                        ) {
                            Text("Yes")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                showDialogConfirmation = false
                            }
                        ) {
                            Text("No")
                        }
                    },


                )

            }






        }
    }
}




