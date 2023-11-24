package com.nbscollege.fitnessapp.mainscreen.main.settings

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LogoutDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Log Out") },
        text = { Text("Are you sure you want to log out?") },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                }
            ) {
                Text("Log Out")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }
        }
    )
}