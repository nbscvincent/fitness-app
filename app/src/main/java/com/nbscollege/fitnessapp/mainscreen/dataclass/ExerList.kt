package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class ExerList(
    val title: String,
    val time: String,
    val route:String,
    val index:Int
)

val ExerciseList = listOf(
    //for abs workout
    ExerList(title = "PLANK", time = "00:45", route = CategoryRoute.ABS.name,1),
    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.ABS.name,2),
    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.ABS.name,3),
    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.ABS.name,4),
    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.ABS.name,5),
    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.ABS.name,6),
    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.ABS.name,7),
    ExerList(title = "SIT-UPS",time = "01:00",route = CategoryRoute.ABS.name,8),
    ExerList(title = "V-UP",time = "01:00",route = CategoryRoute.ABS.name,9),


//for chest workout
    ExerList(title = "PUSH-UPS", time = "00:45", route = CategoryRoute.CHEST.name,1),
    ExerList(title = "INCLINE PUSH-UPS", time = "01:00",route = CategoryRoute.CHEST.name,2),
    ExerList(title = "WIDE ARM PUSH-UPS",time = "01:15",route = CategoryRoute.CHEST.name,3),
    ExerList(title = "DECLINE PUSH-UPS",time = "01:00",route = CategoryRoute.CHEST.name,4),
    ExerList(title = "TRICEPS DIPS",time = "01:30",route = CategoryRoute.CHEST.name,5),
    ExerList(title = "KNEE PUSH-UPS",time = "01:45",route = CategoryRoute.CHEST.name,6),
    ExerList(title = "COBRA STRETCH",time = "01:45",route = CategoryRoute.CHEST.name,7),
    ExerList(title = "CHEST STRETCH",time = "01:00",route = CategoryRoute.CHEST.name,8),

    //for arm workout
    ExerList(title = "ARM CIRCLES CLOCKWISE",time = "01:00",route = CategoryRoute.ARM.name,1),
    ExerList(title = "ARM CIRCLES COUNTERCLOCKWISE",time = "01:00",route = CategoryRoute.ARM.name,2),
    ExerList(title = "MILITARY PUSH-UPS", time = "01:00",route = CategoryRoute.ARM.name,3),
    ExerList(title = "SHOULDER GATORS",time = "01:15",route = CategoryRoute.ARM.name,4),
    ExerList(title = "PUSH-UP & ROTATION",time = "01:30",route = CategoryRoute.ARM.name,5),
    ExerList(title = "MODIFIED PUSH-UP LOW HOLD",time = "01:45",route = CategoryRoute.ARM.name,6),
    ExerList(title = "BURPEES",time = "01:45",route = CategoryRoute.ARM.name,7),
    ExerList(title = "FLOOR TRICEPS DIPS",time = "01:00",route = CategoryRoute.ARM.name,8),

    //for leg workout
    ExerList(title = "SQUATS", time = "00:45", route = CategoryRoute.LEG.name,1),
    ExerList(title = "CALF STRETCH RIGHT",time = "01:00",route = CategoryRoute.LEG.name,2),
    ExerList(title = "CALF STRETCH LEFT",time = "01:00",route = CategoryRoute.LEG.name,3),
    ExerList(title = "BOTTOM LEG LIFT RIGHT", time = "01:00",route = CategoryRoute.LEG.name,4),
    ExerList(title = "BOTTOM LEG LIFT LEFT",time = "01:15",route = CategoryRoute.LEG.name,5),
    ExerList(title = "SIDE LEG CIRCLE RIGHT",time = "01:30",route = CategoryRoute.LEG.name,6),
    ExerList(title = "SIDE LEG CIRCLE LEFT",time = "01:45",route = CategoryRoute.LEG.name,7),
    ExerList(title = "CURTSY LUNGES",time = "01:45",route = CategoryRoute.LEG.name,8),
    ExerList(title = "JUMPING SQUATS",time = "01:00",route = CategoryRoute.LEG.name,9),
    ExerList(title = "WALL SIT",time = "01:00",route = CategoryRoute.LEG.name,10),

    //for shoulder workout
    ExerList(title = "REVERSE PUSH-UPS", time = "00:45", route = CategoryRoute.SHOULDER.name,1),
    ExerList(title = "PIKE PUSH-UPS", time = "01:00",route = CategoryRoute.SHOULDER.name,2),
    ExerList(title = "INCHWORMS",time = "01:15",route = CategoryRoute.SHOULDER.name,3),
    ExerList(title = "HYPER EXTENSION",time = "01:30",route = CategoryRoute.SHOULDER.name,4),
    ExerList(title = "HOVER PUSH-UP",time = "01:45",route = CategoryRoute.SHOULDER.name,5),
    ExerList(title = "HIP HINGE",time = "01:45",route = CategoryRoute.SHOULDER.name,6),
    ExerList(title = "TRICEPS KICKBACKS",time = "01:00",route = CategoryRoute.SHOULDER.name,7),
    ExerList(title = "INCLINE PUSH-UPS",time = "01:00",route = CategoryRoute.SHOULDER.name,8),

)
data class eme(
    val title: String,
    val time: String,
    val route:String,
    val index:Int
)
val emee = listOf(
    eme(title = "PLANK", time = "00:45", route = CategoryRoute.ABS.name,1),
)
