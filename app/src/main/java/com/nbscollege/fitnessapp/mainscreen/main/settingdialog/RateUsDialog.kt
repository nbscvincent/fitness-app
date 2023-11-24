package com.nbscollege.fitnessapp.mainscreen.main.settingdialog

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RateUsDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        icon = {
            // You can use a built-in icon or a custom image here
            Icon(
                imageVector = Icons.Default.RateReview,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color.DarkGray
            )
        },
        title = { Text("Rate Us", textAlign = TextAlign.Center) },
        text = { Text("Do you really want to Rate us?", textAlign = TextAlign.Center) },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                }
            ) {
                Text("Rate us")
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