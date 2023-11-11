package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigationRoute.Screen
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashAnimated(navController: NavController) {

    var startAnimation by remember () { mutableStateOf((false)) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = ""
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.navigate(MainScreen.LogInScreen.name)
    }
    SplashScreen(alpha = alphaAnim.value)

}

@Composable
fun SplashScreen(alpha: Float) {

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(modifier = Modifier
            .size(200.dp),
            painter = painterResource(id = R.drawable.fitness_logo), // Replace with your image resource
            contentDescription = "logo",
        )
    }

}


