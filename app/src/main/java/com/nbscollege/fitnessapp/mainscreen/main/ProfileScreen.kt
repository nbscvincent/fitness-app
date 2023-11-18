package com.nbscollege.fitnessapp.model


import android.annotation.SuppressLint
import android.health.connect.datatypes.HeightRecord
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.navigation.NavController
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar

//enum class SelectedButton2 {
//    Home,
//    Person,
//    Settings
//}
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun profilescreen(navController: NavController) {


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .padding(top=10.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIos,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Back",
                        tint = Color.DarkGray
                    )
                }

            }
        },
        bottomBar = {

        }
    ) { innerPadding ->

        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.White),

            ) {

            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    modifier = Modifier.size(45.dp),
                    contentDescription = "Back",
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "Settings",
                    color = Color.DarkGray,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(registeredUsers) { profile ->
                    Text(
                        "Username: ${profile.username}", color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                    )
                    Text(
                        "Height: ${profile.height}", color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                    )
                    Text(
                        "Weight: ${profile.weight}", color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                    )
                }
            }
        }
    }
}


