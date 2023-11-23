package com.nbscollege.fitnessapp.mainscreen.card


import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExerCateg(
    exer: ExerList, navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }
    var timerStarted by remember { mutableStateOf(false) }
//    var timerRunning by remember { mutableStateOf(false) }

//    Scaffold(
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .height(180.dp)
//                    .background(Color.White)
//                    .fillMaxWidth()
//            ) {

//                SmallFloatingActionButton(
//                    onClick = {
//                        navController.navigate("HomeScreen")
//                    },
//                    containerColor = Color.Transparent,
//                    modifier = Modifier
//                        .padding(start = 5.dp, end = 5.dp)
//                        .zIndex(1f)
//
//                ) {
//                    Icon(Icons.Filled.KeyboardArrowLeft, "Back", modifier = Modifier.size(40.dp))
//                }

//                Image(
//                    modifier = Modifier.fillMaxWidth().height(180.dp),
//                    painter = painterResource(id = category.backgroundImageResourceId),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "NBS LOGO",
//                )

//                Text(
//                    text = "ABS Workout",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 25.sp,
//                    color = Color.Black,
//                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
//
//                )

//            }
//        },
//
//
//        bottomBar = {
//            BottomAppBar {
//
//            }
//        }
//    ) { innerPadding ->
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    // Background image

                    Button(
                        onClick = {
                            showDialog = true
//                            timerRunning = false
                        },
                        shape = RoundedCornerShape(1.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .height(90.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )

                    ) {

                        // Content overlay
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(1.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                exer.title,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Row(

                            ) {
                                Text(
                                    exer.time,
                                    color = Color.Black,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding()
                    )
                    if (showDialog) {
                        AlertDialogExample(
                            onDismissRequest = {
                                showDialog = false
                                timerStarted = false
                            },
                            onConfirmation = {
                                showDialog = false
                                timerStarted = false
                            },
                            onStart = {
                                timerStarted = true
                            },
                            onPause = {
                                timerStarted = false
                            },
                            dialogTitle = "Exercise Timer",
                            icon = Icons.Default.Timer,
                            initialTime = 60L, // Set initial time to 1 minute (60 seconds)
                            timerStarted = timerStarted
                        )
                    }
                }
            }
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    onStart: () -> Unit,
    onPause: () -> Unit,
    dialogTitle: String,
    icon: ImageVector,
    initialTime: Long,
    timerStarted: Boolean
) {
    var remainingTime by remember { mutableStateOf(initialTime) }
    var timerRunning by remember { mutableStateOf(false) }

    val timer = remember {
        object : CountDownTimer(remainingTime * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished / 1000
            }

            override fun onFinish() {
                timerRunning = false
                onDismissRequest()
            }
        }
    }

    DisposableEffect(Unit) {
        if (timerStarted && !timerRunning) {
            timer.start()
            timerRunning = true
        }

        onDispose {
            timer.cancel()
        }
    }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Column {
                Text("Time remaining: $remainingTime seconds")

                if (!timerRunning) {
                    Text("Time's up!")
                }
            }
        },

        confirmButton = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = {
                        if (!timerRunning) {
                            timerRunning = true
                            onStart()
                            timer.start()
                        }
                    }
                ) {
                    Text("Start")
                }

                TextButton(
                    onClick = {
                        timer.cancel()
                        timerRunning = false
                        onPause()
                    }
                ) {
                    Text("Pause")
                }
            }
        },
        onDismissRequest = {
            timer.cancel()
            onDismissRequest()
        },
        dismissButton = {
            TextButton(
                onClick = {
                    timer.cancel()
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

//bakit ganto langya



//                    if (showDialog) {
//                        AlertDialogExample(
//                            onDismissRequest = { showDialog = false },
//                            onConfirmation = {
//                                timerRunning = true // Start the countdown when Confirm is clicked
//                                showDialog = false
//                            },
//                            onStopCountdown = {
//                                timerRunning = false // Stop the countdown when Dismiss is clicked
//                            },
//                            dialogTitle = "Exercise Timer",
//                            dialogText = "This is the exercise timer dialog.",
//                            icon = Icons.Default.Timer,
//                            initialTime = 10L, // Set initial time to 1 minute (60 seconds)
//                            timerRunning = timerRunning
//                        )
//                    }
//                }
//            }
//        )
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AlertDialogExample(
//    onDismissRequest: () -> Unit,
//    onConfirmation: () -> Unit,
//    onStopCountdown: () -> Unit,
//    dialogTitle: String,
//    dialogText: String,
//    icon: ImageVector,
//    initialTime: Long,
//    timerRunning: Boolean
//) {
//    var remainingTime by remember { mutableStateOf(initialTime) }
//
//    val timer = remember {
//        object : CountDownTimer(remainingTime * 1000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                remainingTime = millisUntilFinished / 1000
//            }
//
//            override fun onFinish() {
//                onStopCountdown()
//            }
//        }
//    }
//
//    DisposableEffect(Unit) {
//        if (timerRunning) {
//            timer.start()
//        } else {
//            timer.cancel()
//        }
//
//        onDispose {
//            timer.cancel()
//        }
//    }
//
//    AlertDialog(
//        icon = {
//            Icon(icon, contentDescription = "Example Icon")
//        },
//        title = {
//            Text(text = dialogTitle)
//        },
//        text = {
//            Column {
//                Text("Time remaining: $remainingTime seconds")
//
//                if (!timerRunning) {
//                    Text("Time's up!")
//                }
//            }
//        },
//        onDismissRequest = {
//            timer.cancel()
//            onDismissRequest()
//        },
//        confirmButton = {
//            TextButton(
//                onClick = {
//                    onConfirmation()
//                    if (!timerRunning) {
//                        timer.start()
//                    }
//                }
//            ) {
//                Text("Start")
//            }
//        },
//        dismissButton = {
//            TextButton(
//                onClick = {
//                    timer.cancel()
//                    onStopCountdown()
//                }
//            ) {
//                Text("Stop")
//            }
//        }
//    )
//}