package com.nbscollege.fitnessapp.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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



