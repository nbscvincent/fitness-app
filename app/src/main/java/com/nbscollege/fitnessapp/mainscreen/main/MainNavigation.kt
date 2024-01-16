package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar
import com.nbscollege.fitnessapp.mainscreen.categorycard.ExerciseList
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ArmScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ChestScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.LegScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.ShoulderScreen
import com.nbscollege.fitnessapp.mainscreen.exercisescreen.absScreen.AbsScreen
import com.nbscollege.fitnessapp.mainscreen.settingscreen.GeneralSettings
import com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard.sendFeedback
import com.nbscollege.fitnessapp.model.ProfileScreen
import com.nbscollege.fitnessapp.model.homescreen
import com.nbscollege.fitnessapp.model.settingscreen
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.Screen
import com.nbscollege.fitnessapp.navigation.SettingsRoute
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.viewmodel.LogoutSplashScreen
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainNavigation(navController: NavController, screenViewModel: ScreenViewModel) {

    val navController = rememberNavController()
    var showBottomBar by remember { mutableStateOf(true) }

    val loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val context = LocalContext.current






    var exit by remember { mutableStateOf(false) }


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
                ProfileScreen(screenViewModel, navController,)
                showBottomBar = true
            }

            composable(route = Screen.SettingScreen.name) {
                settingscreen(context, navController,)
                showBottomBar = true
            }
//            composable(route = Screen.ProfileEdit.name) { navController ->
//                val Login = loggedInUsername // Replace this with your actual mechanism to get the logged-in username
//                val targetUsername = "desired_username"
//                registeredUsers.find { it.username == it.username }?.let { loggedInUser ->
//                    UserProfileScreen(loggedInUser) { updatedUser ->
//                        // Update the user in your data source (e.g., registeredUsers)
//                        val index = registeredUsers.indexOfFirst { it.username == it.username }
//                        if (index != -1) {
//                            registeredUsers[index] = updatedUser
//                        }
//                    }
//                }
//
//            }
            navigation(startDestination = SettingsRoute.GeneralSettings.name, route = SettingsRoute.Settings.name) {
                composable(route = SettingsRoute.GeneralSettings.name) { backStackEntry ->





// Now, create an instance of OfflineUserRepository with the userDao



                    GeneralSettings(navController, backStackEntry)
                    showBottomBar = false
                }
            
                composable(route = SettingsRoute.Feed.name, ) {
                    sendFeedback(navController, context)
                    showBottomBar = true
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

                    LogoutSplashScreen(navController,screenViewModel)
                    showBottomBar = false
                }


            }


                composable(route = CategoryRoute.ABS.name) { backStackEntry ->

                    ExerciseList(navController)
                    showBottomBar = false
                }

                composable("CategoryDetails/{bid}") { navBackStackEntry ->
                    val bid = navBackStackEntry.arguments?.getString("bid")

                    bid?.let {
                        AbsScreen(navController = navController, index = bid.toInt())
                    }
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









