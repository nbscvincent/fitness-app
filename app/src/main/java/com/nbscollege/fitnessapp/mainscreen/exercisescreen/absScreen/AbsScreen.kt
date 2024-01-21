package com.nbscollege.fitnessapp.mainscreen.exercisescreen.absScreen

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nbscollege.fitnessapp.mainscreen.dataclass.AbsExerciseList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalWearMaterialApi::class)
@Composable
fun AbsScreen(navController: NavController, index: Int) {

    var originalTime by remember { mutableStateOf(AbsExerciseList[index].time.toLong() * 1000) }
    var remainingTime by remember { mutableStateOf(originalTime) }
    var isTimerRunning by remember { mutableStateOf(false) }
    var isPauseButtonVisible by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Red) }

    var progress by remember { mutableFloatStateOf(1f) }


    var openAlertDialog = remember { mutableStateOf(false) }






    val countDownTimer = remember {
        object : CountDownTimer(remainingTime, 1000) {
            override  fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                progress = millisUntilFinished.toFloat() / originalTime.toFloat()

            }

            override fun onFinish() {
                if (index < AbsExerciseList.size - 1) {
                    navController.navigate("AbsDetails/${index + 1}") {
                        // Clear the back stack up to AbsDetails screen (exclusive)
                        popUpTo("ABS") {
                            inclusive = false
                        }
                    }


                } else {
                    openAlertDialog.value = true

                }
            }
        }
    }

    // Start or pause the timer
    DisposableEffect(isTimerRunning) {
        if (isTimerRunning) {
            countDownTimer.start()
        } else {
            countDownTimer.cancel()
        }

        onDispose {
            countDownTimer.cancel()
        }
    }

    Scaffold(
        topBar = {
            IconButton(
                onClick = {
                    navController.navigate("ABS") {
                        // Clear the back stack up to AbsDetails screen (inclusive)
                        popUpTo("ABS") {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .zIndex(3f)
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )
            }



            Column(
                modifier = Modifier.height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box (
                    modifier = Modifier.fillMaxWidth(1f),
                    contentAlignment = Alignment.Center,

                ) {
                    Text(
                        AbsExerciseList[index].title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.graphicsLayer(translationY = 0f, translationX = 0f)
                    )

                }

//                Box(
//                    modifier = Modifier
//                        .size(150.dp)
//                        .padding(16.dp)
//                        .drawBehind {
//                            // Draw circular progress
//                            drawArc(
//                                color = Color.Black,
//                                startAngle = 0f,
//                                sweepAngle = 360 * progress,
//                                useCenter = false,
//                                style = Stroke(width = 8.dp.toPx())
//                            )
//
//                            // Draw timer text
//                            drawIntoCanvas { canvas ->
//                                val text = "${remainingTime / 1000}"
//                                val paint = Paint().asFrameworkPaint().apply {
//                                    color = Color(0xFF800000).toArgb()
//                                    textAlign = android.graphics.Paint.Align.CENTER
//                                    textSize = 50.sp.toPx()
//                                }
//                                canvas.nativeCanvas.drawText(
//                                    text,
//                                    size.width / 2,
//                                    size.height / 2 + paint.textSize / 3, // Adjusted Y-coordinate
//                                    paint
//                                )
//                            }
//                        }
//
//
//                )
            }



        }, // END OF TOPBAR
        bottomBar  = {

            BottomAppBar(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxSize()
                    .background(Color.Green),
                containerColor = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Button(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        onClick = {
                            if (!isTimerRunning) {
                                countDownTimer.start()
                                isTimerRunning = true
                                buttonColor = Color.Gray
                            }
                        },
                        enabled = !isTimerRunning,
                        colors = ButtonDefaults.buttonColors(buttonColor)
                    ) {
                        Text("Start")
                    }
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//
//                    ) {
//                        Button(
//                            modifier = Modifier.fillMaxWidth().height(50.dp),
//                            onClick = {
//                                if (index < ExerciseList.size - 1) {
//                                    navController.navigate("CategoryDetails/${index + 1}")
//                                } else {
//                                    navController.navigate("ExerciseList")
//                                }
//                            },
//                            enabled = !isTimerRunning,
//                            colors = ButtonDefaults.buttonColors(Color.Blue)
//                        ) {
//                            Text("Next")
//                        }
//                    }
                }




            } // END BOTTOMBAR
        }
    ) { innerPadding ->
        // Content of your screen goes here

//        Column(
//            modifier = Modifier
//                .background(Color.White)
//                .fillMaxSize()
//                .padding(innerPadding)
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                LazyColumn(
//                    modifier = Modifier.padding(0.dp),
//                ) {
//                    item {
//
//                        Text(
//                            text = ExerciseList[index].title,
//                            fontWeight = FontWeight.Bold,
//                            textAlign = TextAlign.Center,
//                            color = Color(0xFF6562DF),
//                        )
//                        Text(
//                            text = "${ExerciseList[index].time} seconds",
//                            fontWeight = FontWeight.Bold,
//                            textAlign = TextAlign.Center,
//                            color = Color(0xFF6562DF),
//                        )
//                    }
//                }
//            }
//        }

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
                    modifier = Modifier.padding(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    item {

                        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(
                            AbsExerciseList[index].animation
                        ))

                        val preloaderProgress by animateLottieCompositionAsState(
                            composition,
                            iterations = LottieConstants.IterateForever,
                            isPlaying = true
                        )

                        LottieAnimation(
                            modifier = Modifier.size(300.dp),
                            progress = preloaderProgress,
                            composition =  composition,

                            )



//                        Text(
//                            text = ExerciseList[index].title,
//                            fontWeight = FontWeight.Bold,
//                            textAlign = TextAlign.Center,
//                            color = Color(0xFF6562DF),
//                        )

                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .padding(16.dp)
                                .drawBehind{
                                    // Draw circular progress
                                    drawArc(
                                        color = Color(0xFF800000),
                                        startAngle = 0f,
                                        sweepAngle = 360 * progress,
                                        useCenter = false,
                                        style = Stroke(width = 8.dp.toPx())
                                    )

                                    // Draw timer text
                                    drawIntoCanvas { canvas ->
                                        val text = "${remainingTime / 1000}"
                                        val paint = Paint().asFrameworkPaint().apply {
                                            color = Color(0xFF6562DF).toArgb()
                                            textAlign = android.graphics.Paint.Align.CENTER
                                            textSize = 50.sp.toPx()
                                        }
                                        canvas.nativeCanvas.drawText(
                                            text,
                                            size.width / 2,
                                            size.height / 2 + paint.textSize / 3,
                                            paint
                                        )
                                    }
                                }
                        )
                    }

                }

            }
        }
    }


    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = {
                navController.navigate("ABS") {
                    // Clear the back stack up to AbsDetails screen (exclusive)
                    popUpTo("ABS") {
                        inclusive = true
                    }
                }

                openAlertDialog.value = false
            },
            title = {
                Text(
                    text = "Great Job!!!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            },
            text = {
                Text(
                    text = "Keep it up!",
                    fontSize = 16.sp,
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Navigate to "ABS" when confirmed
                        navController.navigate("ABS") {
                            // Clear the back stack up to AbsDetails screen (exclusive)
                            popUpTo("ABS") {
                                inclusive = true
                            }
                        }

                        openAlertDialog.value = false
                    },
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Gray),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        "continue",
                        color = Color.White
                    )
                }
            },
            dismissButton = {

            }
        )
    }



}







