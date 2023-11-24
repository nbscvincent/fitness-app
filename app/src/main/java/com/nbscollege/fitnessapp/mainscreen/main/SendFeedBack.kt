package com.nbscollege.fitnessapp.mainscreen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.navigation.Screen

fun sendFeedback(navController: NavController, context: Context) {
    val recipient = "cevangelista@student.nbscollege.edu.ph"
    val subject = "Feedback on Your App"

    val intent = Intent(Intent.ACTION_SENDTO).apply {
      data = Uri.parse("mailto:$recipient?subject=$subject")
    }
    ContextCompat.startActivity(context, intent, null)
    navController.navigate(Screen.SettingScreen.name)




}