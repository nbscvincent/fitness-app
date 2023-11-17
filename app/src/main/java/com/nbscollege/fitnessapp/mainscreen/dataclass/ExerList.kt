package com.nbscollege.fitnessapp.mainscreen.dataclass

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.ui.graphics.vector.ImageVector
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute
import com.nbscollege.fitnessapp.navigation.ExerRoute
import com.nbscollege.fitnessapp.navigation.SettingsRoute

data class ExerList(
    val title: String,
    val time: String,
    val route:String
)

val ExerciseList = listOf(
    ExerList("JUMPING JACKS", "00:45", ExerRoute.ABS.name),
    ExerList("ABDOMINAL CRUNCHES", "01:00", ExerRoute.ABS.name),
    ExerList("RUSSIAN TWIST", "01:30", ExerRoute.ABS.name),
    ExerList("MOUNTAIN CLIMBER", "01:45", ExerRoute.ABS.name),
    ExerList("HEEL TOUCH", "01:45", ExerRoute.ABS.name),
    ExerList("LEG RAISES", "01:45", ExerRoute.ABS.name),
    ExerList("PLANK", "00:20", ExerRoute.ABS.name),
)