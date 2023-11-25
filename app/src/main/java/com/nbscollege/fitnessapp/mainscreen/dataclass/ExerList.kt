package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class ExerList(
    val title: String,
    val time: String,
    val route:String
)

val ExerciseList = listOf(
    ExerList(title = "JUMPING JACKS", time = "00:45", route = CategoryRoute.ABS.name),
    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.ABS.name),
    ExerList(title = "RUSSIAN TWIST",time = "01:30",route = CategoryRoute.ABS.name),
    ExerList(title = "MOUNTAIN CLIMBER",time = "01:45",route = CategoryRoute.ABS.name),
    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.ABS.name),
    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.ABS.name),
    ExerList(title = "PLANK",time = "00:20",route = CategoryRoute.ABS.name),
)