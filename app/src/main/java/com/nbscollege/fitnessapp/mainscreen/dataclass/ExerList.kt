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
    ExerList(title = "SIT-UPS",time = "01:00",route = CategoryRoute.ABS.name),
    ExerList(title = "V-UP",time = "01:00",route = CategoryRoute.ABS.name),


//for chest workout
    ExerList(title = "PUSH-UPS", time = "00:45", route = CategoryRoute.CHEST.name),
    ExerList(title = "INCLINE PUSH-UPS", time = "01:00",route = CategoryRoute.CHEST.name),
    ExerList(title = "WIDE ARM PUSH-UPS",time = "01:15",route = CategoryRoute.CHEST.name),
    ExerList(title = "DECLINE PUSH-UPS",time = "01:00",route = CategoryRoute.CHEST.name),
    ExerList(title = "TRICEPS DIPS",time = "01:30",route = CategoryRoute.CHEST.name),
    ExerList(title = "KNEE PUSH-UPS",time = "01:45",route = CategoryRoute.CHEST.name),
    ExerList(title = "COBRA STRETCH",time = "01:45",route = CategoryRoute.CHEST.name),
    ExerList(title = "CHEST STRETCH",time = "01:00",route = CategoryRoute.CHEST.name),

    //for arm workout
    ExerList(title = "ARM CIRCLES CLOCKWISE",time = "01:00",route = CategoryRoute.ARM.name),
    ExerList(title = "ARM CIRCLES COUNTERCLOCKWISE",time = "01:00",route = CategoryRoute.ARM.name),
    ExerList(title = "MILITARY PUSH-UPS", time = "01:00",route = CategoryRoute.ARM.name),
    ExerList(title = "SHOULDER GATORS",time = "01:15",route = CategoryRoute.ARM.name),
    ExerList(title = "PUSH-UP & ROTATION",time = "01:30",route = CategoryRoute.ARM.name),
    ExerList(title = "MODIFIED PUSH-UP LOW HOLD",time = "01:45",route = CategoryRoute.ARM.name),
    ExerList(title = "BURPEES",time = "01:45",route = CategoryRoute.ARM.name),
    ExerList(title = "FLOOR TRICEPS DIPS",time = "01:00",route = CategoryRoute.ARM.name),

    //for leg workout
    ExerList(title = "SQUATS", time = "00:45", route = CategoryRoute.LEG.name),
    ExerList(title = "CALF STRETCH RIGHT",time = "01:00",route = CategoryRoute.LEG.name),
    ExerList(title = "CALF STRETCH LEFT",time = "01:00",route = CategoryRoute.LEG.name),
    ExerList(title = "BOTTOM LEG LIFT RIGHT", time = "01:00",route = CategoryRoute.LEG.name),
    ExerList(title = "BOTTOM LEG LIFT LEFT",time = "01:15",route = CategoryRoute.LEG.name),
    ExerList(title = "SIDE LEG CIRCLE RIGHT",time = "01:30",route = CategoryRoute.LEG.name),
    ExerList(title = "SIDE LEG CIRCLE LEFT",time = "01:45",route = CategoryRoute.LEG.name),
    ExerList(title = "CURTSY LUNGES",time = "01:45",route = CategoryRoute.LEG.name),
    ExerList(title = "JUMPING SQUATS",time = "01:00",route = CategoryRoute.LEG.name),
    ExerList(title = "WALL SIT",time = "01:00",route = CategoryRoute.LEG.name),

    //for shoulder workout
    ExerList(title = "REVERSE PUSH-UPS", time = "00:45", route = CategoryRoute.SHOULDER.name),
    ExerList(title = "PIKE PUSH-UPS", time = "01:00",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "INCHWORMS",time = "01:15",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "HYPER EXTENSION",time = "01:30",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "HOVER PUSH-UP",time = "01:45",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "HIP HINGE",time = "01:45",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "TRICEPS KICKBACKS",time = "01:00",route = CategoryRoute.SHOULDER.name),
    ExerList(title = "INCLINE PUSH-UPS",time = "01:00",route = CategoryRoute.SHOULDER.name),

)