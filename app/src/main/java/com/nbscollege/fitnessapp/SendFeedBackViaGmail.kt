package com.nbscollege.fitnessapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity

@Composable
fun sendFeedbackViaGmail(context: Context) {
    val recipient = "cevangelista@student.nbscollege.edu.ph"
    val subject = "Feedback on Your App"
    val openAlertDialog = remember { mutableStateOf(true) }

    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { /* Handle dismiss if needed */ },
            title = { Text("Confirmation") },
            text = { Text("Would you like to send feedback via your email app?") },
            confirmButton = {
                Button(onClick = {
                    // Navigate the user to their email app
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$recipient")
                        putExtra(Intent.EXTRA_SUBJECT, subject)
                    }
                    startActivity(context, intent, null)
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(onClick = {
                    // Handle dismissal if needed
                    openAlertDialog.value = false
                }) {
                    Text("No")
                }
            }
        )
    }

}