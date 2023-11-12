package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar
import com.nbscollege.fitnessapp.mainscreen.Category
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.AbsScreen
import com.nbscollege.fitnessapp.model.homescreen
import com.nbscollege.fitnessapp.model.profilescreen
import com.nbscollege.fitnessapp.model.settingscreen
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainNavigation(navController: NavController) {

    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        },
    ) {

        NavHost(navController = navController, startDestination = Screen.HomeScreen.name) {
        //composable(route = Screen.SplashScreen.name) { SplashAnimated(navController) }
        composable(route = Screen.HomeScreen.name) { homescreen(navController) }
        composable(route = Screen.ProfileScreen.name) { profilescreen(navController) }
        composable(route = Screen.SettingScreen.name) { settingscreen(navController) }
        composable(route = CategoryRoute.ABS.name) { AbsScreen(navController)}

    }

    }




}





