import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun TimerDialog() {
    var isTimerRunning by remember { mutableStateOf(false) }
    var timerValue by remember { mutableStateOf(0) }
    var timerJob by remember { mutableStateOf<Job?>(null) }
    var dialogOpen by remember { mutableStateOf(true) }
    var elapsedTime by remember { mutableStateOf(0) }
    var initialTimerValue by remember { mutableStateOf(60) }

    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = {
                // Handle dialog dismissal
                dialogOpen = false
            },
            title = {
                Text(text = "Timer Dialog")
            },
            text = {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = formatTime(timerValue))
                }
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (!isTimerRunning) {
                        // Start Button
                        IconButton(
                            onClick = {
                                isTimerRunning = true
                                timerJob = TimerScope.launch {
                                    while (timerValue > 0) {
                                        delay(1000)
                                        timerValue--
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null
                            )
                        }
                    } else {
                        // Pause Button
                        IconButton(
                            onClick = {
                                isTimerRunning = false
                                timerJob?.cancel()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Pause,
                                contentDescription = null
                            )
                        }
                    }

                    // Restart Button
                    IconButton(
                        onClick = {
                            isTimerRunning = false
                            timerJob?.cancel()
                            timerValue = initialTimerValue
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.RestartAlt,
                            contentDescription = null
                        )
                    }

                    // Close Button
                    IconButton(
                        onClick = {
                            isTimerRunning = false
                            timerJob?.cancel()
                            dialogOpen = false
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}
