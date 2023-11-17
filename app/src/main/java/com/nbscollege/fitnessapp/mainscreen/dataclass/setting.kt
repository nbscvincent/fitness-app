package com.nbscollege.fitnessapp.mainscreen.dataclass

import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
    General("General Settings", Icons.Default.KeyboardArrowRight, SettingsRoute.GeneralSettings.name),
    General("Send Feedback", Icons.Default.KeyboardArrowRight, SettingsRoute.Feed.name),
    General("Rate Us", Icons.Default.KeyboardArrowRight, SettingsRoute.Rate.name),
    General("Log out", Icons.Default.KeyboardArrowRight, SettingsRoute.LogOut.name),
)


