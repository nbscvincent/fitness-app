package com.nbscollege.fitnessapp.mainscreen.main.settingdialog

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LogoutDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        icon = {
            // You can use a built-in icon or a custom image here
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color.DarkGray
            )
        },

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