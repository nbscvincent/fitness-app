package com.nbscollege.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat

import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : ComponentActivity() {


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val screenViewModel: ScreenViewModel by viewModels()








        screenViewModel.runSplashScreen()
        screenViewModel.isProgressVisible

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                screenViewModel.splashLoaded.value
            }
        }



        setContent {

            SplashNav(screenViewModel)
        }

    }
}


//            FitnessAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                }
//            }


