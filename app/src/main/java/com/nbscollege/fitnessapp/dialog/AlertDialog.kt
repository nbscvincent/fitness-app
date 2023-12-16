package com.nbscollege.fitnessapp.dialog

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.nbscollege.fitnessapp.R


@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
//    dialogText: String,
    icon: ImageVector,
) {
    val darkGreen = colorResource(id = R.color.DarkGreen)

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon", modifier = Modifier.size(50.dp),tint = Color.DarkGray)
        },
        title = {
            Text(text = dialogTitle)
        },
//        text = {
//            Text(text = dialogText)
//        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Cancel")
            }
        }
    )
}


@Composable
fun alertdialog(
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
    var originalRemainingTime by remember { mutableStateOf(remainingTime) }
    var timerRunning by remember { mutableStateOf(false) }
    var timerPaused by remember { mutableStateOf(false) }

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

//                if (!timerRunning) {
//                    Text("Time's up!")
//                }
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
                        if (timerRunning && !timerPaused) {
                            timer.cancel()
                            timerRunning = false
                            timerPaused = true
                            originalRemainingTime = remainingTime
                            onPause()
                        } else if (timerPaused) {
                            timer.start()
//                        originalRemainingTime.run {start()}
                            timerRunning = true
//                        remainingTime.run {start()}
                            timerPaused = false
                            onStart()
                        }
                    }
                ) {
                    Text(if (timerPaused) "Resume" else "Pause")
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
        dismissButton = { }

    )
}



