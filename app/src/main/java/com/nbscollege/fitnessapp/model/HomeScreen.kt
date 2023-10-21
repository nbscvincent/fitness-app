package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.BadgeDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

private val Any.Report: Any
    get() { TODO ()}

class HomeScreen {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homescreen() {


        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    Text(
                        text = "FITNESS WORKOUT",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .graphicsLayer(translationY = 70f, translationX = 30f)

                    )

                }
            },
        )
        { innerPadding ->

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "BEGINNER",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        //.graphicsLayer(translationY = 100f, translationX = 30f)
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .padding(top= 100.dp)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {

                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "JUMPING JACKS"+
                                            "\n"+"\n"+
                                            "00:20"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 11.dp)

                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "ABDOMINAL CRUNCHES"+
                                            "\n"+"\n"+
                                            "16x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 45.dp)
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "RUSSIAN TWIST"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "MOUNTAIN CLIMBERS"+
                                            "\n"+"\n"+
                                            "16x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "HEEL TOUCH"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "LEG RAISES"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "PLANK"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "ABDOMINAL CRUNCHES"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "RUSSIAN TWIST"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "MOUNTAIN CLIMBERS"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "HEEL TOUCH"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "LEG RAISES"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "PLANK"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "COBRA STRETCH"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "SPINE LUMBAR TWIST STRETCH LEFT"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                                modifier = Modifier
                                    .border(1.dp, color = Color.Black)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White),
                            ) {
                                Text(
                                    "SPINE LUMBAR TWIST STRETCH RIGHT"+
                                            "\n"+"\n"+
                                            "20x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}


