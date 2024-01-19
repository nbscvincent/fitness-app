package com.nbscollege.fitnessapp.mainscreen.categorycard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nbscollege.fitnessapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChestExerciseList (navController: NavController) {



    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
//                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {

                SmallFloatingActionButton(
                    onClick = {
                        navController.navigate("HomeScreen")
                    },
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .zIndex(3f)

                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft, "Back",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.abs),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                )
            }
        },
//        bottomBar = {
//            BottomAppBar {
//
//            }
//        }
    ) { innerPadding ->
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

                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "EXERCISES",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }

                    item {
                        com.nbscollege.fitnessapp.mainscreen.dataclass.ChestExerciseList.forEachIndexed { index, exercise ->

                            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(exercise.animation))

                            val preloaderProgress by animateLottieCompositionAsState(
                                composition,
                                iterations = LottieConstants.IterateForever,
                                isPlaying = true
                            )

                            LottieAnimation(
                                modifier = Modifier.size(500.dp),
                                progress = preloaderProgress,
                                composition =  composition,

                                )


                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),

                                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                            ) {


                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White)
                                        .height(90.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                ) {

                                    Row(

                                    ) {
                                        val preloaderProgress by animateLottieCompositionAsState(
                                            composition,
                                            iterations = LottieConstants.IterateForever,
                                            isPlaying = true
                                        )

                                        LottieAnimation(
                                            modifier = Modifier.size(100.dp).padding(bottom=20.dp),
                                            progress = preloaderProgress,
                                            composition =  composition,

                                            )

                                    }



                                    Button(
                                        onClick = {
                                            navController.navigate("ChestDetails/$index")
                                        },
                                        shape = RoundedCornerShape(1.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(16.dp))
                                            .height(90.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                                    ) {



                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(start = 100.dp),
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = exercise.title,
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier
                                                ,
                                                textAlign = TextAlign.Center
                                            )

                                            Text(

                                                "${exercise.time} Seconds",
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier
                                                ,
                                                textAlign = TextAlign.Center,

                                                )

                                        }



                                    }


                                }

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                        }


                    }

                }



            }
        }

    }

}



