package com.nbscollege.fitnessapp

import Auth
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

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
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainNavigation(navController: NavController,screenViewModel: ScreenViewModel) {

    val navController = rememberNavController()
    var showBottomBar by remember { mutableStateOf(true) }

    var exit by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(key1 = exit) {
        if (exit) {
            delay(2000)
            exit = false
        }
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        },
    ) {

        NavHost(navController = navController, startDestination = Screen.HomeScreen.name) {

            composable(route = Screen.HomeScreen.name) {
                homescreen(navController,)
                showBottomBar = true
            }

            composable(route = Screen.ProfileScreen.name) {
                profilescreen(screenViewModel ,navController,)
                showBottomBar = true
            }
            composable(route = Screen.SettingScreen.name) {
                settingscreen(context, navController,)
                showBottomBar = true
            }


            navigation(startDestination = SettingsRoute.GeneralSettings.name, route = SettingsRoute.Settings.name) {
                composable(route = SettingsRoute.GeneralSettings.name) { backStackEntry ->
                    GeneralSettings(navController, backStackEntry)
                    showBottomBar = false
                }
                composable(route = SettingsRoute.Feed.name, ) {  backStackEntry ->
                    sendFeedbackViaGmail(navController,context, backStackEntry)
                    showBottomBar = false
                }
                composable(route = SettingsRoute.Rate.name) {
//                    GeneralSettings(navController, backStackEntry)
//                    showBottomBar = false
                }
                composable(route = SettingsRoute.LogOut.name) {
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
                    val openAlertDialog = remember { mutableStateOf(true) }

                    SplashNav(screenViewModel = ScreenViewModel())
                    showBottomBar = false



                }


            }

            navigation(startDestination = CategoryRoute.ABS.name, route = CategoryRoute.CATEGORY.name) {
                composable(route = CategoryRoute.ABS.name) { backStackEntry ->
                    AbsScreen(navController, backStackEntry)
                    showBottomBar = false
                }
                composable(route = CategoryRoute.CHEST.name) { backStackEntry ->
                    ChestScreen(navController, backStackEntry)
                    showBottomBar = false
                }
                composable(route = CategoryRoute.ARM.name) { backStackEntry ->
                    ArmScreen(navController,backStackEntry)
                    showBottomBar = false
                }
                composable(route = CategoryRoute.LEG.name) { backStackEntry ->
                    LegScreen(navController,backStackEntry)
                    showBottomBar = false
                }
                composable(route = CategoryRoute.SHOULDER.name) { backStackEntry ->
                    ShoulderScreen(navController,backStackEntry)
                    showBottomBar = false
                }
            }

        }
    }

}









