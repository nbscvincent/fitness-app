package com.nbscollege.fitnessapp.viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.SplashNav
import kotlinx.coroutines.delay

@Composable
fun LogoutSplashScreen(
    navController: NavController,
    screenViewModel: ScreenViewModel,
) {
    val state = screenViewModel.isLoggedOut.collectAsState()
    screenViewModel.logoutUser()

    if (state.value) {
         SplashNav(screenViewModel)
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
        ) {
            Image(
                modifier = androidx.compose.ui.Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.fitness_logo),
                contentDescription = "NBS LOGO"
            )



            Box(androidx.compose.ui.Modifier.height(25.dp))
            CircularProgressIndicator(
                modifier = androidx.compose.ui.Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            // Run the resetSubjectRegistered function after a delay
            LaunchedEffect(Unit) {
                delay(0) // Adjust the delay as needed
                screenViewModel.resetLogoutUser()
            }
        }
    }
}