package com.nbscollege.fitnessapp.mainscreen.settingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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

            Text("Current Password")

            OutlinedTextField(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),

                label = { Text("Current Password", fontWeight = FontWeight.Medium, color = if (viewModel.status) Color.Red else Color.Black ) },
                value = currentPassword,
                singleLine = true,
                onValueChange = { currentPassword = it },
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "current password"
                    )

                },
                shape = RoundedCornerShape(12.dp),

            )

            Text("New Password")

            OutlinedTextField(

                modifier = Modifier.absolutePadding(left = 20.dp, bottom = 11.dp),

                label = { Text("New Password", fontWeight = FontWeight.Medium) },
                value = newPassword,
                singleLine = true,
                onValueChange = { newPassword = it },
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "new password"
                    )
                },
                shape = RoundedCornerShape(12.dp),

                )

            Text("Confirm New Password", modifier = Modifier.absolutePadding(left = 5.dp, bottom = 5.dp))

            OutlinedTextField(

                modifier = Modifier
                    .absolutePadding(left = 20.dp, bottom = 11.dp),
                label = { Text("Confirm Password", fontWeight = FontWeight.Medium) },
                value = confirmPassword,
                singleLine = true,
                onValueChange = { confirmPassword = it },
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "confirm password"
                    )
                },
                shape = RoundedCornerShape(12.dp),

                )

            Button(
               onClick = {


                   coroutineScope.launch {
                       if (currentPassword.isNotEmpty() && newPassword.isNotEmpty() &&
                           newPassword == confirmPassword && confirmPassword.isNotEmpty()
                               ) {
                           // Call your ViewModel function to change the password
//                           viewModel.changePassword(currentPassword, newPassword, navController)
//                           viewModel.status = false
//                           val prefer = context.getSharedPreferences("prefs", 0)
//                           prefer.edit()
//                               .clear()
//                               .apply()

                           viewModel.changePassword(currentPassword, newPassword, navController)
                           showDialogConfirmation = true
                       } else {

                       }
                   }



               } // end of onclick button
            ) {
                Text("Change Password")
            }

            if (!viewModel.oldPasswordCorrect) {
                Text("Current password is incorrect", color = Color.Red)
            }

            if (showDialogConfirmation) {
                AlertDialog(
                    onDismissRequest = {
                        showDialogConfirmation = false
                    },
                    title = {
                        Text("Confirm Password Change")
                    },
                    text = {
                        Text("Are you sure you want to change the password?")
                    },
                    confirmButton = {
                        Button(
                            onClick = {

                                // Call your ViewModel function to change the password

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
                    }
                )
            }






        }
    }
}




