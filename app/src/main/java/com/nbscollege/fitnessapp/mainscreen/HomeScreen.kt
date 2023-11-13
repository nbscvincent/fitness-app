package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment

import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.nbscollege.fitnessapp.mainscreen.CategoryCard
import com.nbscollege.fitnessapp.mainscreen.categoryExercise
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.AbsScreen
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.Screen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homescreen(navController: NavHostController) {

//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screen.HomeScreen.name){
//        composable(route = CategoryRoute.ABS.name){
//            AbsScreen(navController = navController)
//        }
//        composable(route = Screen.HomeScreen.name){
//            homescreen(navController = navController)
//        }
//    }

    Scaffold(
        topBar = {

            Box(
                modifier = Modifier
//                    .height(50.dp)
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
            BottomAppBar {

            }
        }
    ) { innerPadding ->
        // Content of your screen goes here

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

//                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "EXERCISE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }

                    items(categoryExercise) { category ->
                        CategoryCard(category = category, navController)
                    }





                }
            }

        }
    }
}




//                LazyColumn(
//
//                ) {
//                    item {
//
//                        // ------ BEGINNER ----- //
//                        Text(
//                            text = "BEGINNER",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 20.sp,
//                            color = Color.Black,
//                            modifier = Modifier.graphicsLayer(translationY = 50f, translationX = 30f),
//                        )
//                        Spacer(modifier = Modifier.height(20.dp),)
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp),
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.abs), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp)),
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                    colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent,
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "ABS BEGINNER",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 190.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "11 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.pushup), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "CHEST BEGINNER",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 170.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Text(
//                                        text = "11 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding(end = 170.dp)
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.arm), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//
//                                Column(
//
//                                ) {
//                                    Text(
//                                        text = "ARM BEGINNER",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier.padding(end = 180.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Text(
//                                        text = "19 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier.padding(end = 200.dp)
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.leg), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "LEG BEGINNER",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 190.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "23 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.shoulderback), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                    colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "SHOULDER & BACK BEGINNER",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "17 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        // ----- START INTER WORKOUT ------ //
//
//                        Text(
//                            text = "INTERMEDIATE",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 20.sp,
//                            color = Color.Black,
//                            modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
//                        )
//                        Spacer(modifier = Modifier.height(20.dp))
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.interabs), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "ABS INTERMEDIATE",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "21 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.interchest), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "CHEST INTERMEDIATE",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "14 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.interarm), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "ARM INTERMEDIATE",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "25 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.interleg), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "LEG INTERMEDIATE",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "36 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(170.dp)
//                                .padding(8.dp)
//                        ) {
//                            // Background image
//                            Image(
//                                painter = painterResource(id = R.drawable.interback), // Replace with your image resource
//                                contentDescription = null,
//                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clip(RoundedCornerShape(16.dp))
//                            )
//
//                            // TextButton
//                            Button(
//                                onClick = {
//
//                                },
//                                shape = RoundedCornerShape(1.dp),
//                                modifier = Modifier
//
//                                    .fillMaxWidth()
//                                    .clip(RoundedCornerShape(16.dp))
//                                    .height(170.dp),
//                                colors = ButtonDefaults.buttonColors(
//                                    containerColor = Color.Transparent
//                                )
//                            ) {
//                                Column (
//
//                                ) {
//                                    Text(
//                                        text = "SHOULDER & BACK INTERMEDIATE",
//                                        color = Color.White,
//                                        fontWeight = FontWeight.Bold,
//                                        fontSize = 25.sp,
//                                        modifier = Modifier
//                                            .padding(end = 150.dp),
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp),)
//                                    Text(
//                                        text = "17 EXERCISES",
//                                        color = Color.White,
//                                        fontSize = 15.sp,
//                                        modifier = Modifier
//                                            .padding()
//                                    )
//                                }
//                            }
//                        }
//
//
//
//
//
//
//                    } //lazycolumn end bracket



