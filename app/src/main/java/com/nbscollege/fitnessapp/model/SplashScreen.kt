package com.nbscollege.fitnessapp.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.screen
import kotlinx.coroutines.delay



@Composable
fun SplashLoading(navController : NavController) {
    val isSplash by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(3000) // Adjust the delay duration as needed
    }



}


