package com.nbscollege.fitnessapp.mainscreen.categorycard

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExerCateg(
    exerList: ExerList, navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }
    var timerStarted by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Button(
                onClick = {
                    navController.navigate("CategoryDetails/{bid}")
                    showDialog = true
                    timerStarted = false
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
                        .padding(1.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        exerList.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    TextRange(
                        exerList.time,

                    )
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
                    onStart = {
                        timerStarted = true
                    },
                    onPause = {
                        timerStarted = false
                    },
                    dialogTitle = exerList.title,
                    icon = Icons.Default.Timer,
                    initialTime = exerList.time.toLong(),
                    timerStarted = timerStarted
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
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
                        if (timerRunning) {
                            timer.cancel()
                            timerRunning = false
                            onPause()
                        }
                    }
                ) {
                    Text("Pause")
                }
                TextButton(
                    onClick = {
                        timer.cancel()
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        },
        onDismissRequest = {
            timer.cancel()
            onDismissRequest()
        },
        dismissButton = {}
    )
}

