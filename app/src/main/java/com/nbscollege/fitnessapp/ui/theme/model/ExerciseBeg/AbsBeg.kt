package com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nbscollege.fitnessapp.R

class AbsBeg {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun absbeg() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.abs),
                contentDescription = painterResource(id = R.drawable.abs).toString(),
                contentScale = ContentScale.None,
                modifier = Modifier
                    .height(180.dp)
                    .width(650.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
        SmallFloatingActionButton(
            onClick = { },
            containerColor = Color.Transparent,
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
        ) {
            Icon(Icons.Filled.KeyboardArrowLeft, "Back")
        }
        }

            Column(
                modifier = Modifier
                    .padding(start = 15.dp , top = 130.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "ABS BEGINNER",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        Column(
            modifier = Modifier
                .padding(start = 20.dp , top = 200.dp),
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

        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {


                Button(
                    onClick = { },
                    shape = RoundedCornerShape(1.dp),

                    ) {
                    Text(
                        "JUMPING JACKS",
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
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(1.dp),
                ) {
                    Text(
                        "COBRA STRETCH",
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
                        "SPINE LUMBAR TWIST STRETCH LEFT",
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
                        "SPINE LUMBAR TWIST STRETCH RIGHT",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
            }
        }

    }
}