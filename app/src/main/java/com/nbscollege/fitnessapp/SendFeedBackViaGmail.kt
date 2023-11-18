package com.nbscollege.fitnessapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity

@Composable
fun sendFeedbackViaGmail(current: Context) {
    val context = LocalContext.current

    // Replace the following with your email address and subject
    val recipient = "cevangelista@student.nbscollege.edu.ph"
    val subject = "Feedback on Your App"

    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$recipient")
        putExtra(Intent.EXTRA_SUBJECT, subject)
    }

    if (intent.resolveActivity(context.packageManager) != null) {
        // Launch the Gmail app
        startActivity(context, intent, null)
    } else {
        // Handle the case where the Gmail app is not installed
        // You might want to show a Snackbar or Toast to inform the user
        // that the Gmail app is not available.
    }
}