package com.nbscollege.fitnessapp.mainscreen.exercisescreen

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerciseList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsScreen(navController: NavController, index: Int) {

    var originalTime by remember { mutableStateOf(ExerciseList[index].time.toLong() * 1000) }
    var remainingTime by remember { mutableStateOf(originalTime) }
    var isTimerRunning by remember { mutableStateOf(false) }
    var isPauseButtonVisible by remember { mutableStateOf(false) }
    var buttonColor by remember { mutableStateOf(Color.Red) }

    var isSplashScreenVisible by remember { mutableStateOf(false) }
    val splashScreenCountdownTimer = remember {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // You can update UI for countdown display if needed
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

    val countDownTimer = remember {
        object : CountDownTimer(remainingTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
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
    LaunchedEffect(isSplashScreenVisible) {
        if (isSplashScreenVisible) {
            splashScreenCountdownTimer.start()
        }
    }

    // Start or pause the timer
    LaunchedEffect(isTimerRunning) {
        if (isTimerRunning) {
            countDownTimer.start()
        }
    }

    Scaffold(
        topBar = {

            // ... (TopBar)
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.height(150.dp)) {

                Button(
                    modifier = Modifier.fillMaxWidth().height(150.dp),
                    onClick = {
                        if (!isTimerRunning) {
                            countDownTimer.start()
                            isTimerRunning = true
                            buttonColor = Color.Gray
                        }
                        isSplashScreenVisible = true
                    },
                    enabled = !isTimerRunning,
                    colors = ButtonDefaults.buttonColors(buttonColor)
                ) {
                    Text("Start")
                }
            } // END BOTTOMBAR
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
                            text = "${ExerciseList[index].time} seconds",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )
                    }
                }
            }
        }

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
                            text = "${remainingTime / 1000} seconds",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )
                    }
                }

            }
        }
    }
}


