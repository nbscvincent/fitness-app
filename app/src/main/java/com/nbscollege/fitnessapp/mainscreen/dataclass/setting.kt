package com.nbscollege.fitnessapp.mainscreen.dataclass

import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.SettingsRoute

data class General(
    val title: String,
    val icon: ImageVector,
    val route: String
)

val settingsList = listOf(
    General("General Settings", Icons.Default.ArrowForwardIos, SettingsRoute.GeneralSettings.name),
    General("Send Feedback", Icons.Default.ArrowForwardIos, SettingsRoute.Feed.name),
    General("Rate Us", Icons.Default.ArrowForwardIos, SettingsRoute.Rate.name),
    General("Log out", Icons.Default.ArrowForwardIos, SettingsRoute.LogOut.name),
)


