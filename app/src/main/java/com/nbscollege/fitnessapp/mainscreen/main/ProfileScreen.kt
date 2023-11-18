package com.nbscollege.fitnessapp.model


import android.annotation.SuppressLint
import android.health.connect.datatypes.HeightRecord
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.ui.Alignment

import androidx.navigation.NavController
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar
import java.util.Locale

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
                    .padding(top = 10.dp)
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
            BottomAppBar {

            }
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
                    imageVector = Icons.Outlined.Person,
                    modifier = Modifier.size(45.dp),
                    contentDescription = "Back",
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    "Profile",
                    color = Color.DarkGray,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            LazyColumn(

                modifier = Modifier.padding(top=100.dp).background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                items(registeredUsers) { profile ->


                    Column(

                    ) {
                        Text(
                            "Username: ${profile.username}",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Thin,
                            modifier = Modifier.padding(start = 40.dp, top=10.dp)
                        )
                        Text(
                            "Height: ${profile.height}",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Thin,
                            modifier = Modifier.padding(start = 40.dp,top=10.dp)
                        )
                        Text(
                            "Weight: ${profile.weight}",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Thin,
                            modifier = Modifier.padding(start = 40.dp,top=10.dp)
                        )

                        val height = profile.height
                        val weight = profile.weight


                        if (height != null && weight != null) {

                            val bmi = weight / (height * height) * 10000
//                            val bmiText = String.format(Locale.getDefault(), "BMI: %.2f - $bmiCategory", bmi)
                            val bmiCategory = when {
                                bmi < 18.5 -> "Underweight"
                                bmi < 24.9 -> "Normal Weight"
                                bmi < 29.9 -> "Overweight"
                                else -> "Obese"
                            }
                            // Display BMI
                            Text(
                                "BMI: %.2f".format(bmi),
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                            )
                            Text(
                                "Category: $bmiCategory",
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                            )
                        } else {
                            // Handle the case where height or weight couldn't be converted to numbers
                            Text(
                                "BMI: Invalid height or weight",
                                color = Color.Red, // or any color you prefer for error messages
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}


