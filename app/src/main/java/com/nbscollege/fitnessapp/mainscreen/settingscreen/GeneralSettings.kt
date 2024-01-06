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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun GeneralSettings(navController: NavController, backStackEntry: NavBackStackEntry) {

    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
                value = "",
                onValueChange = { currentPassword = it },
                label = { Text("Current Password") }
            )

            Text("New Password")

            OutlinedTextField(
                value = "",
                onValueChange = { newPassword = it},
                singleLine = true,
                label = { Text("New Password") }
            )

            Text("Confirm New Password")

            OutlinedTextField(
                value = "",
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm New Password") }
            )

            OutlinedTextField(

                modifier = Modifier
                    ,
                label = { Text("Username", fontWeight = FontWeight.Medium) },
                value = currentPassword,
                singleLine = true,
                onValueChange = { currentPassword = it },
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Username"
                    )
                },
              

            )


            Button(
               onClick = {

               }
            ) {
                Text("Change Password")
            }

        }
    }
}