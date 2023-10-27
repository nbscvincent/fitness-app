package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Navibottom(navController: NavHostController) {

        BottomAppBar(
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // HOME BUTTON
                    Button(
                        onClick = {
//                                isHome = !isHome
                            navController.navigate(route = "Home")
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
                            tint = Color.Black,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    // PERSON BUTTON
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
                    // SETTINGS BUTTON
                    Button(
                        onClick = {

//                                isPerson = !isPerson
                            // navController.navigate(route = "profile")
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent),
                    ) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Profile",
                            tint = Color.Black,
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    // ABOUT BUTTON OR INFO
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
                    Button(
                        onClick = {
//                                isSettings = !isSettings
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent),
                    ) {

                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color.Black,
                            modifier = Modifier.size(40.dp)
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
                    Button(
                        onClick = {
//                                isAbout = !isAbout
                            navController.navigate(route = "About")
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent),
                    ) {

                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About",
                            tint = Color.Black,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }


            }
        )
    }

