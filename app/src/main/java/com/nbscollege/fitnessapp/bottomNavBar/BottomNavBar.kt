package com.nbscollege.fitnessapp.bottomNavBar

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nbscollege.fitnessapp.navigation.Screen

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, Icons.Outlined.Home, Screen.HomeScreen.name),
        BottomNavItem("Profile", Icons.Default.Person, Icons.Outlined.Person, Screen.ProfileScreen.name),
        BottomNavItem("Settings", Icons.Default.Settings, Icons.Outlined.Settings, Screen.SettingScreen.name)
    )
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)


    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar (
        modifier = Modifier.background(color = Color.Red)
    ) {

        items.forEachIndexed { index, item ->
            NavigationBarItem(
//                selected = currentRoute == item.route,
//                selected = selectedItem == index,
                selected = currentRoute == item.route,
//                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }

//                    selectedItem = index
//                    navController.navigate(item.route) {
//                        // Pop up to the start destination of the graph to
//                        // avoid building up a large stack of destinations
//
//                        popUpTo(navController.graph.startDestinationId)
//                        // Avoid multiple copies of the same destination when
//                        // reselecting the same item
//                        launchSingleTop = true
//                    }



//                    navController.navigate(item.route) {
//                        selectedItem = index
//                        launchSingleTop = true
//                    }
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        imageVector = if (index == selectedItem) {
                            item.selectedIcon

                        } else item.selectedIcon,

                        contentDescription = item.title
                    )
                }
            )
        }
    }

}