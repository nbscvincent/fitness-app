package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class ExerList(
    val title: String,
    val time: String,
    val route:String
)

val ExerciseList = listOf(
    //for abs workout
    ExerList(title = "PLANK", time = "00:45", route = CategoryRoute.ABS.name),
    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.ABS.name),
    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.ABS.name),
    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.ABS.name),
    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.ABS.name),
    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.ABS.name),
    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.ABS.name),
//for chest workout
    ExerList(title = "PLANKTON", time = "00:45", route = CategoryRoute.CHEST.name),
    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.CHEST.name),
    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.CHEST.name),
    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.CHEST.name),
    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.CHEST.name),
    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.CHEST.name),
    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.CHEST.name),

    //for arm workout
    ExerList(title = "PLANKTON", time = "00:45", route = CategoryRoute.ARM.name),
    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.ARM.name),
    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.ARM.name),
    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.ARM.name),
    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.ARM.name),
    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.ARM.name),
    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.ARM.name),
)