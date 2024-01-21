package com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

fun sendFeedback(navController: NavController, context: Context) {
    val recipient = "cevangelista2021@student.nbscollege.edu.ph"
    val subject = "Feedback on Fitness-App"

    val intent = Intent(Intent.ACTION_SENDTO).apply {
      data = Uri.parse("mailto:$recipient?subject=$subject")
    }
    ContextCompat.startActivity(context, intent, null)
}