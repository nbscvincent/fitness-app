package com.nbscollege.fitnessapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.model.homescreen
import com.nbscollege.fitnessapp.model.profilescreen
import com.nbscollege.fitnessapp.model.settingscreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { homescreen(navController)}
        composable("Profile") { profilescreen(navController)}
        composable("Settings") { settingscreen(navController)}
    }

}

