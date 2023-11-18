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
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar
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
            composable(route = Screen.HomeScreen.name) { backStackEntry ->
                homescreen(navController, backStackEntry.arguments?.getString(Screen.HomeScreen.name))
            }
            composable(route = Screen.ProfileScreen.name) { backStackEntry ->
                profilescreen(navController, backStackEntry.arguments?.getString(Screen.ProfileScreen.name))
            }
            composable(route = Screen.SettingScreen.name) { backStackEntry ->
                settingscreen(navController, backStackEntry.arguments?.getString(Screen.SettingScreen.name))
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
                    GeneralSettings(navController)
                }

            }

            navigation(startDestination = CategoryRoute.ABS.name, route = CategoryRoute.CATEGORY.name) {
                composable(route = CategoryRoute.ABS.name) { backStackEntry ->  AbsScreen(navController, backStackEntry) }
                composable(route = CategoryRoute.CHEST.name) { backStackEntry -> ChestScreen(navController, backStackEntry) }
                composable(route = CategoryRoute.ARM.name) { backStackEntry -> ArmScreen(navController,backStackEntry) }
                composable(route = CategoryRoute.LEG.name) { backStackEntry -> LegScreen(navController,backStackEntry) }
                composable(route = CategoryRoute.SHOULDER.name) { backStackEntry ->ShoulderScreen(navController,backStackEntry) }
            }

        }
    }
}










