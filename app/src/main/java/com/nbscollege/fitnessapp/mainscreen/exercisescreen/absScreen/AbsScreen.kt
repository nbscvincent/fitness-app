package com.nbscollege.fitnessapp.mainscreen.exercisescreen.absScreen

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerciseList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalWearMaterialApi::class)
@Composable
fun AbsScreen(navController: NavController, index: Int) {

    var originalTime by remember { mutableStateOf(ExerciseList[index].time.toLong() * 1000) }
    var remainingTime by remember { mutableStateOf(originalTime) }
    var isTimerRunning by remember { mutableStateOf(false) }
    var isPauseButtonVisible by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Red) }

    var progress by remember { mutableFloatStateOf(1f) }








    val countDownTimer = remember {
        object : CountDownTimer(remainingTime, 1000) {
            override  fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                progress = millisUntilFinished.toFloat() / originalTime.toFloat()

            }

            override fun onFinish() {
                if (index < ExerciseList.size - 1) {
                    navController.navigate("CategoryDetails/${index + 1}")
                } else {
                    navController.navigate("ExerciseList")
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

            Column(
                modifier = Modifier.height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

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
                ) {

                    item {
                        Text(
                            text = ExerciseList[index].title,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )
                        Text(
                            text = "${remainingTime / 1000} seconds left",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )

                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .padding(16.dp)
                                .drawBehind {
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
}





