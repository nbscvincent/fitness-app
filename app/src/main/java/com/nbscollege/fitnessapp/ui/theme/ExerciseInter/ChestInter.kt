package com.nbscollege.fitnessapp.ui.theme.ExerciseInter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

class ChestInter {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun chestinter() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SmallFloatingActionButton(
                onClick = { },
                containerColor = Color.Transparent,
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp)
                    .zIndex(1f)
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, "Back")
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 130.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "ABS INTERMEDIATE",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 200.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = " 20 mins • 16 Workouts",
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Calling the ButtonList composable to display the buttons
            ButtonList()
        }

    }

    @Composable
    fun ButtonList() {
        LazyColumn(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),

                        ) {
                        Text(
                            "       JUMPING JACKS       ",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "ABDOMINAL CRUNCHES",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "RUSSIAN TWIST",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "MOUNTAIN CLIMBERS",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "HEEL TOUCH",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "LEG RAISES",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "PLANK",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "ABDOMINAL CRUNCHES",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "RUSSIAN TWIST",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "MOUNTAIN CLIMBERS",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "HEEL TOUCH",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "LEG RAISES",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(1.dp),
                    ) {
                        Text(
                            "PLANK",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }

                    }
                }
            }

// last brace for buttonlist
        }

    // last brace for class
    }

