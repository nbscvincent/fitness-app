package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.model.SplashAnimated
import com.nbscollege.fitnessapp.model.homescreen
import com.nbscollege.fitnessapp.model.profilescreen
import com.nbscollege.fitnessapp.model.settingscreen
import com.nbscollege.fitnessapp.navigationRoute.Screen


enum class SelectedButton {
    Home,
    Person,
    Settings,
    SplashScreen
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainNavigation(navController: NavController) {

    val navController = rememberNavController()
    var selectedButton by remember { mutableStateOf(SelectedButton.Home) }


    Scaffold(
        bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // HOME BUTTON
                        Button(
                            onClick = {
                                selectedButton = SelectedButton.Home
                                navController.navigate(route = Screen.HomeScreen.name)
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                        ) {

                            Icon(
                                imageVector = Icons.Default.Home, contentDescription = "Home",
                                tint = if (selectedButton == SelectedButton.Home) Color.Blue else Color.Black,
                                modifier = Modifier.size(40.dp)
                            )
                        }


                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .then(Modifier.drawWithContent {
                                    // Draw a border on the right side
                                    drawLine(
                                        color = Color.Gray,
                                        start = Offset(size.width, 0f),
                                        end = Offset(size.width, size.height),
                                        strokeWidth = 1.dp.toPx()
                                    )
                                }),
                        )

                        // PERSON BUTTON
                        Button(
                            onClick = {

                                selectedButton = SelectedButton.Person
                                navController.navigate(route = Screen.ProfileScreen.name)

                            },
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person, contentDescription = "Profile",
                                tint = if (selectedButton == SelectedButton.Person) Color.Blue else Color.Black,
                                modifier = Modifier.size(40.dp),
                            )
                        }

                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .fillMaxHeight()
                                .then(Modifier.drawWithContent {
                                    // Draw a border on the right side
                                    drawLine(
                                        color = Color.Gray,
                                        start = Offset(size.width, 0f),
                                        end = Offset(size.width, size.height),
                                        strokeWidth = 1.dp.toPx()
                                    )
                                }),
                        )


                        // SETTINGS BUTTON
                        Button(
                            onClick = {
                                selectedButton = SelectedButton.Settings
                                navController.navigate(Screen.SettingScreen.name)
                            },
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                        ) {

                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = if (selectedButton == SelectedButton.Settings) Color.Blue else Color.Black,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
            }
        },
    ) {

        NavHost(navController = navController, startDestination = Screen.HomeScreen.name) {
        //composable(route = Screen.SplashScreen.name) { SplashAnimated(navController) }
        composable(route = Screen.HomeScreen.name) { homescreen(navController) }
        composable(route = Screen.ProfileScreen.name) { profilescreen(navController) }
        composable(route = Screen.SettingScreen.name) { settingscreen(navController) }

    }

    }




}





