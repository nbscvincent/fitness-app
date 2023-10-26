package com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.nbscollege.fitnessapp.R

class ChestBeg {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun chestbeg() {

        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                ) {
                    SmallFloatingActionButton(
                        onClick = { },
                        containerColor = Color.Transparent,
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .zIndex(1f)

                    ) {
                        Icon(Icons.Filled.KeyboardArrowLeft, "Back", modifier = Modifier.size(40.dp))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.abs),
                        contentDescription = "",
                        modifier = Modifier
                            .zIndex(0f)
                            .fillMaxWidth()
                            .border(1.dp, color = Color.Transparent),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "ABS BEGINNER",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .graphicsLayer(translationY = 170f, translationX = 30f)
                    )
                    Text(
                        text = " 20 mins • 16 Workouts",
                        fontSize = 13.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .graphicsLayer(translationY = 300f, translationX = 25f)
                    )
                }
            }
        )
        { innerPadding ->
            Column(modifier = Modifier.padding(top = 180.dp)) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        item{
//                            Column (
//                                modifier = Modifier
//                                .padding(start = 30.dp , end = 25.dp),
//                                horizontalAlignment = Alignment.Start
//                            ){
//                                Text(
//                                    text = " 20 mins • 16 Workouts",
//                                    fontSize = 13.sp,
//                                    color = Color.White,
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                    .zIndex(1f)
//                                    .graphicsLayer(translationY = 290f, translationX = 30f)
//                                        .padding(start = 30.dp,)
//                                )
//                            }
//                        }
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
                                            "00:30"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 42.dp)
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
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 77.dp)
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
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 39.dp)
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
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 70.dp)
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
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 28.dp)
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
                                            "16x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 20.dp)
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
                                            "00:20"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,

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
                                            "12x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 77.dp)
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
                                            "32x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                    .padding(start = 39.dp)
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
                                            "12x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 70.dp)
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
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 28.dp)
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
                                            "14x"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 20.dp)
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
                                            "00:30"+
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
                                            "00:30"+
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
                                    "SPINE LUMBAR TWIST STRETCH LEFT"+
                                            "\n"+"\n"+
                                            "00:30"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 135.dp)
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
                                            "00:30"+
                                            "\n"+"\n",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    modifier = Modifier
                                        .padding(start = 135.dp)
                                )
                            }
                        }
                    }
            }
        }


        }
    }
}
