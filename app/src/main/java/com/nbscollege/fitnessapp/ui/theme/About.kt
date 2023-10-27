package com.nbscollege.fitnessapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.nbscollege.fitnessapp.Navibottom
import com.nbscollege.fitnessapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(navController: NavHostController) {
    var isPerson by remember { mutableStateOf(true) }
    var isHome by remember { mutableStateOf(true) }
    var isSettings by remember { mutableStateOf(true) }
    var isabout by remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "FITNESS WORKOUT",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
                )
            }
        },
        bottomBar = {
            Navibottom(navController = navController)
        }
//        bottomBar = {
//            BottomAppBar {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    // HOME BUTTON
//                    Button(
//                        onClick = {
////                                isHome = !isHome
//                            navController.navigate(route = "Home")
//                        },
//                        modifier = Modifier
//                            .width(100.dp)
//                            .height(100.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Transparent
//                        ),
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Home, contentDescription = "Home",
//                            tint = Color.Black,
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }
//                    // PERSON BUTTON
//                    Box(
//                        modifier = Modifier
//                            .width(1.dp)
//                            .fillMaxHeight()
//                            .then(Modifier.drawWithContent {
//                                // Draw a border on the right side
//                                drawLine(
//                                    color = Color.Gray,
//                                    start = Offset(size.width, 0f),
//                                    end = Offset(size.width, size.height),
//                                    strokeWidth = 1.dp.toPx()
//                                )
//                            }),
//                    )
//                    // SETTINGS BUTTON
//                    Button(
//                        onClick = {
//
////                                isPerson = !isPerson
//                            // navController.navigate(route = "profile")
//                        },
//                        modifier = Modifier
//                            .width(100.dp)
//                            .height(100.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Transparent),
//                    ) {
//                        Icon(imageVector = Icons.Default.Person, contentDescription = "Profile",
//                            tint = Color.Black,
//                            modifier = Modifier.size(40.dp),
//                        )
//                    }
//                    // ABOUT BUTTON OR INFO
//                    Box(
//                        modifier = Modifier
//                            .width(2.dp)
//                            .fillMaxHeight()
//                            .then(Modifier.drawWithContent {
//                                // Draw a border on the right side
//                                drawLine(
//                                    color = Color.Gray,
//                                    start = Offset(size.width, 0f),
//                                    end = Offset(size.width, size.height),
//                                    strokeWidth = 1.dp.toPx()
//                                )
//                            }),
//                    )
//                    Button(
//                        onClick = {
////                                isSettings = !isSettings
//                        },
//                        modifier = Modifier
//                            .width(100.dp)
//                            .height(100.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Transparent),
//                    ) {
//
//                        Icon(
//                            imageVector = Icons.Default.Settings,
//                            contentDescription = "Settings",
//                            tint = Color.Black,
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }
//                    Box(
//                        modifier = Modifier
//                            .width(2.dp)
//                            .fillMaxHeight()
//                            .then(Modifier.drawWithContent {
//                                // Draw a border on the right side
//                                drawLine(
//                                    color = Color.Gray,
//                                    start = Offset(size.width, 0f),
//                                    end = Offset(size.width, size.height),
//                                    strokeWidth = 1.dp.toPx()
//                                )
//                            }),
//                    )
//                    Button(
//                        onClick = {
////                                isAbout = !isAbout
//                            navController.navigate(route = "About")
//                        },
//                        modifier = Modifier
//                            .width(100.dp)
//                            .height(100.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Transparent),
//                    ) {
//
//                        Icon(
//                            imageVector = Icons.Default.Info,
//                            contentDescription = "About",
//                            tint = Color.Black,
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }
//                }
//            }
//        },
    ) { innerPadding ->
        // Content of your screen goes here

//        Column (verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier
//            .background(Color.White)){
//
//
//            SmallFloatingActionButton(
//                onClick = {
//                    navController.navigate("Home")
//                },
//                containerColor = Color.Black,
//                modifier = Modifier
//                    .padding(start = 5.dp, end = 5.dp)
//                    .zIndex(1f)
//
//            ) {
//                Icon(Icons.Filled.KeyboardArrowLeft, "Back", modifier = Modifier.size(40.dp))
//            }
//        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ){
            Text(
                "Fitness App",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(start = 42.dp)
            )
            Text(
                "App Version: 1.0.1",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(start = 42.dp)
            )
            SmallFloatingActionButton(
                onClick = {
                    navController.navigate("Home")
                },
                containerColor = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .zIndex(1f)

            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, "Back", modifier = Modifier.size(40.dp))
            }
        }
    }
}