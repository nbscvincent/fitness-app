package com.nbscollege.fitnessapp

import Auth

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.example.model.LoginScreen
import com.example.example.model.SignUp
import com.nbscollege.fitnessapp.model.SplashScreen
import com.nbscollege.fitnessapp.navigation.Routes
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashNav(screenViewModel: ScreenViewModel,) {
    val navController: NavHostController = rememberNavController()

    Scaffold {
        NavHost(navController = navController, startDestination =  Auth.Splash.name) {
            composable(route = Auth.Splash.name) {
                SplashScreen(navController, screenViewModel)
            }
            composable(route = Auth.LogInScreen.name) {
                LoginScreen(navController)
            }
            composable(route = Auth.SignUpScreen.name) {
                SignUp(navController)
            }
            
            composable(route = Routes.MAIN.name) {
                mainNavigation()
            }
        }
    }
}


