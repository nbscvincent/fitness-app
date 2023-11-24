package com.nbscollege.fitnessapp.mainscreen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun sendFeedback(context: Context) {
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:")
        putExtra(Intent.EXTRA_EMAIL, arrayOf("your_email@example.com"))
        putExtra(Intent.EXTRA_SUBJECT, "Feedback")
        putExtra(Intent.EXTRA_TEXT, "Enter your feedback here...")
    }

    if (emailIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(emailIntent)
    } else {
        // Handle the case where no email app is available
        Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
    }
}