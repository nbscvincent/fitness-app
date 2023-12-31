package com.nbscollege.fitnessapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.nbscollege.fitnessapp.model.settingscreen
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.navigation.SettingsRoute
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.rememberUpdatedState

@Composable
fun sendFeedbackViaGmail(
    navController: NavHostController,
    context: Context,
) {
    val recipient = "cevangelista@student.nbscollege.edu.ph"
    val subject = "Feedback on Your App"
    val openAlertDialog = remember { mutableStateOf(true) }



Column(

) {
    if (openAlertDialog.value) {
        AlertDialog(
            onDismissRequest = { /* Handle dismiss if needed */ },
            title = { Text("Confirmation") },
            text = { Text("Would you like to send feedback via your email app?") },
            confirmButton = {
                Button(onClick = {
                    // Navigate the user to their email app

                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$recipient?subject=$subject")
                    }
                    startActivity(context, intent, null)
                    navController.navigate(Screen.SettingScreen.name)
                }) {
                    Text("Continue")


                }

            },

            dismissButton = {
                Button(onClick = {
                    navController.navigate(Screen.SettingScreen.name)
                    openAlertDialog.value = false
                }) {
                    Text("Go Back")
                }
            }
        )
    }

}



//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//
//        Column(
//            modifier = Modifier.align(Alignment.Center),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            Image(
//                modifier = Modifier.size(300.dp),
//                painter = painterResource(id = R.drawable.fitness_logo),
//                contentDescription = "NBS LOGO"
//            )
//            Button(onClick = {
//                navController.navigate(Screen.SettingScreen.name)
//            }) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    Text("Go Back Settings", fontSize = 19.sp, modifier = Modifier.padding(1.dp))
//                }
//            }
//
//        }
//    }



}