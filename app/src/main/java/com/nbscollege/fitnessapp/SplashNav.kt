package com.nbscollege.fitnessapp

import Auth

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.example.model.LoginScreen
import com.example.example.model.SignUpScreen
import com.nbscollege.fitnessapp.mainscreen.Category
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.AbsScreen
import com.nbscollege.fitnessapp.model.SplashScreen
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.Routes
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.delay
import kotlin.system.exitProcess



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashNav(screenViewModel: ScreenViewModel) {
    val navController: NavHostController = rememberNavController()

    var showToast by remember { mutableStateOf(false) }

    var exit by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if(showToast){
        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
        showToast= false
    }


    LaunchedEffect(key1 = exit) {
        if (exit) {
            delay(2000)
            exit = false
        }
    }


    Scaffold {
        NavHost(navController = navController, startDestination = Auth.Splash.name) {
            composable(route = Auth.Splash.name) {
                SplashScreen(navController, screenViewModel)
            }
            composable(route = Auth.LogInScreen.name) {
                LoginScreen(navController)
            }
            composable(route = Auth.SignUpScreen.name) {
                SignUpScreen(navController)
            }
            composable(route = Routes.MAIN.name) {
                BackHandler(enabled = true) {
                    if (exit) {
                        context.startActivity(Intent(Intent.ACTION_MAIN).apply {
                            addCategory(Intent.CATEGORY_HOME)
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        })
                    } else {
                        exit = true
                        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
                    }
                }
                    mainNavigation(navController)
            }


        }
    }
}

