package com.nbscollege.fitnessapp

import ScreenViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.example.model.LogInScreen
import com.example.example.model.SignUpScreen
import com.nbscollege.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenViewModel: ScreenViewModel by viewModels()

        screenViewModel.runSplashScreen()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                screenViewModel.loading.value
            }
        }

        setContent {
            FitnessAppTheme {
                // A surface container using the 'background' color from the theme
                var log = LogInScreen()
                log.Login()
            }



        }
    }
}