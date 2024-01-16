package com.nbscollege.fitnessapp.mainscreen.settingscreen.settingdialog

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel

@Composable
fun LogoutDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
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
            val context = LocalContext.current
            Button(
                onClick = {
                    onConfirm()

                    loginViewModel.status = false
                    val prefer = context.getSharedPreferences("prefs", 0)
                    prefer.edit()
                        .clear()
                        .apply()
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