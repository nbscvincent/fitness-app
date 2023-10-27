package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingscreen(navController : NavController) {
    var isPerson by remember { mutableStateOf(true) }
    var isHome by remember { mutableStateOf(true) }
    var isSettings by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {

            Box(
                modifier = Modifier
                    .height(50.dp).background(Color.White).fillMaxWidth()
            ) {
                Text(
                    text = "Profile",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
                )


            }

        },
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
                            isHome = !isHome
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

                            isPerson = !isPerson

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
                            tint = Color.Black,
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



                    Button(
                        onClick = {
                            isSettings = !isSettings
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
                            tint = Color.Black,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        },
    ) { innerPadding ->



    }
    }
