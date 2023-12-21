package com.nbscollege.fitnessapp.authscreen.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.Routes

@Composable
fun LoginSplashScreen(
    navController: NavHostController,
    loginSplashViewModel: LoginSplashViewModel
) {
    // Trigger the splash screen loading logic
    LaunchedEffect(key1 = Unit) {
        loginSplashViewModel.showSplashScreen()
    }

    // Observe the splashShown state
    val splashShown by loginSplashViewModel.splashShown.collectAsState()

    // When the splash screen is shown, navigate to the main screen
    if (splashShown) {
        navController.navigate(Routes.MAIN.name)
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
        ) {
            Image(
                modifier = androidx.compose.ui.Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.fitness_logo),
                contentDescription = "NBS LOGO"
            )

            Spacer(modifier = androidx.compose.ui.Modifier.padding(16.dp))

            Box(androidx.compose.ui.Modifier.height(25.dp))
            LinearProgressIndicator(
                modifier = androidx.compose.ui.Modifier.width(150.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                trackColor = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}