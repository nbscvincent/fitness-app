package com.nbscollege.fitnessapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object HomeScreen: BottomBarScreen (
        route = "homescreen",
        title = "HomeScreen",
        icon = Icons.Default.Home,
    )

    object ProfileScreen: BottomBarScreen (
        route = "profileScreen",
        title = "ProfileScreen",
        icon = Icons.Default.Person,
    )

    object SettingScreen: BottomBarScreen (
        route = "settingscreen",
        title = "SettingScreen",
        icon = Icons.Default.Settings,
    )
}
