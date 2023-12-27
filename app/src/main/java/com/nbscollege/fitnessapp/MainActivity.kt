package com.nbscollege.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.nbscollege.fitnessapp.database.repository.UserRepository
import com.nbscollege.fitnessapp.model.ProfileScreen
import com.nbscollege.fitnessapp.ui.user.LoginViewModel

import com.nbscollege.fitnessapp.ui.user.RegistrationViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val screenViewModel: ScreenViewModel by viewModels()

        val viewModel: LoginViewModel by viewModels()


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


