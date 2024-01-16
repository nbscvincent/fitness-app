package com.nbscollege.fitnessapp.model

import Auth
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.Routes
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,

    loginViewModel: LoginViewModel
) {
//    val state = screenViewModel.splashLoaded.collectAsState()
//    screenViewModel.runSplashScreen()

    var appearSplash by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = appearSplash){
        delay(2000)
        appearSplash = true
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.fitness_logo),
                contentDescription = "NBS LOGO"
            )
            Box(Modifier.height(25.dp))
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    if(appearSplash){
        if(!loginViewModel.status){
            navController.navigate(Auth.Splash.name)
         
        }else {
            
        }
    }

//    if (state.value) {
//
//        navController.navigate(Auth.LogInScreen.name)
//    } else {
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Image(
//                modifier = Modifier.size(300.dp),
//                painter = painterResource(id = R.drawable.fitness_logo),
//                contentDescription = "NBS LOGO"
//            )
//            Box(Modifier.height(25.dp))
//            CircularProgressIndicator(
//                modifier = Modifier.width(64.dp),
//                color = MaterialTheme.colorScheme.surfaceVariant,
//            )
//        }
//    }
}

