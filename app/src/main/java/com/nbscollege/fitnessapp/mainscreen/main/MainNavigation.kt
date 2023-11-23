package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.example.model.SignUpScreen
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar
import com.nbscollege.fitnessapp.mainscreen.card.ExerCateg
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerciseList
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.AbsScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ArmScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ChestScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.LegScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ShoulderScreen
import com.nbscollege.fitnessapp.mainscreen.settingscreen.GeneralSettings
import com.nbscollege.fitnessapp.model.homescreen
import com.nbscollege.fitnessapp.model.profilescreen
import com.nbscollege.fitnessapp.model.settingscreen
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.navigation.SettingsRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainNavigation(navController: NavController) {

    val navController = rememberNavController()
var bottomBar by remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        },
    ) {

        NavHost(navController = navController, startDestination = Screen.HomeScreen.name) {

//        navigation(startDestination = Routes.MAIN.name,route = Screen.HomeScreen.name) {
//            composable(route = Screen.HomeScreen.name){ homescreen(navController)}
//            composable(route = CategoryRoute.ABS.name) { AbsScreen(navController) }
//        }
            composable(route = Screen.HomeScreen.name) {
                homescreen(navController)
            }
            composable(route = Screen.ProfileScreen.name) {
                profilescreen(navController)
            }
            composable(route = Screen.SettingScreen.name) {
                settingscreen(navController)
            }
            navigation(startDestination = SettingsRoute.GeneralSettings.name, route = SettingsRoute.Settings.name) {
                composable(route = SettingsRoute.GeneralSettings.name) {
                    GeneralSettings(navController)
                }
                composable(route = SettingsRoute.Feed.name) {
                    GeneralSettings(navController)
                }
                composable(route = SettingsRoute.Rate.name) {
                    GeneralSettings(navController)
                }
                composable(route = SettingsRoute.LogOut.name) {
                    SignUpScreen(navController)
                }

            }

            navigation(startDestination = CategoryRoute.ABS.name, route = CategoryRoute.CATEGORY.name) {
                composable(route = CategoryRoute.ABS.name) { AbsScreen(navController)
                    bottomBar = false  }
                composable(route = CategoryRoute.CHEST.name) { ChestScreen(navController) }
                composable(route = CategoryRoute.ARM.name) { ArmScreen(navController) }
                composable(route = CategoryRoute.LEG.name) { LegScreen(navController) }
                composable(route = CategoryRoute.SHOULDER.name) { ShoulderScreen(navController) }
            }
//            navigation(startDestination = CategoryRoute.ABS.name, route = ExerRoute.ABS.name) {
//                composable(route = ExerRoute.ABS.name) { ExerciseList }
//                composable(route = ExerRoute.CHEST.name) { ChestScreen(navController) }
//                composable(route = ExerRoute.ARM.name) { ArmScreen(navController) }
//                composable(route = ExerRoute.LEG.name) { LegScreen(navController) }
//                composable(route = ExerRoute.SHOULDER.name) { ShoulderScreen(navController) }
//            }

        }
    }
}











