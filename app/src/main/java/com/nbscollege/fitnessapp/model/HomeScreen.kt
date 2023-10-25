package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.nbscollege.fitnessapp.R


class HomeScreen {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homescreen() {


        Scaffold(

            topBar = {

                Box(
                    modifier = Modifier
                        .height(50.dp).background(Color.White).fillMaxWidth()
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(modifier = Modifier.padding(top = 10.dp),
                            onClick = {
                                // Handle Home button click
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                        }

                        Divider(
                            modifier = Modifier
                                .width(0.5.dp) // Adjust the width of the divider
                                .fillMaxHeight()
                                .background(Color.White) // Color of the divider line
                        )

                        IconButton(modifier = Modifier.padding(top = 10.dp),
                            onClick = {
                                // Handle Report button click
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Report")
                        }

                        Divider(
                            modifier = Modifier
                                .width(0.5.dp) // Adjust the width of the divider
                                .fillMaxHeight()
                                .background(Color.White) // Color of the divider line
                        )

                        IconButton(modifier = Modifier.padding(top = 10.dp),
                            onClick = {
                                // Handle Settings button click
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings"
                            )
                        }
                    }
                }
            },
        ) { innerPadding ->
            // Content of your screen goes here

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

                LazyColumn(

                ) {
                    item {

                        // ------ BEGINNER ----- //
                        Text(
                            text = "BEGINNER",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.graphicsLayer(translationY = 50f, translationX = 30f)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(170.dp),
                                    colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Column (

                                ) {
                                    Text(
                                        text = "ABS BEGINNER",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 25.sp,
                                        modifier = Modifier
                                            .padding(end = 200.dp)
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "11 EXERCISES",
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        modifier = Modifier
                                            .padding()
                                    )
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "CHEST BEGINNER",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "ARM BEGINNER",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "LEG BEGINNER",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "SHOULDER & BACK BEGINNER",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        // ----- START INTER WORKOUT ------ //

                        Text(
                            text = "INTERMEDIATE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
                        )
                        Spacer(modifier = Modifier.height(20.dp))


                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier

                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "ABS INTERMEDIATE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "CHEST INTERMEDIATE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "ARM INTERMEDIATE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "LEG INTERMEDIATE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(8.dp)
                        ) {
                            // Background image
                            Image(
                                painter = painterResource(id = R.drawable.abs_logo), // Replace with your image resource
                                contentDescription = null,
                                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(16.dp))
                            )

                            // TextButton
                            Button(
                                onClick = {

                                },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "SHOULDER INTERMEDIATE",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(start = 11.dp)
                                )
                            }
                        }


                    }
                }
            }
        }
    }
}




