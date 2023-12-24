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
////for chest workout
//    ExerList(title = "PLANKTON", time = "00:45", route = CategoryRoute.CHEST.name),
//    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.CHEST.name),
//    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.CHEST.name),
//    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.CHEST.name),
//    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.CHEST.name),
//    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.CHEST.name),
//    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.CHEST.name),
//
//    //for arm workout
//    ExerList(title = "PLANKTON", time = "00:45", route = CategoryRoute.ARM.name),
//    ExerList(title = "ABDOMINAL CRUNCHES", time = "01:00",route = CategoryRoute.ARM.name),
//    ExerList(title = "RUSSIAN TWIST",time = "01:15",route = CategoryRoute.ARM.name),
//    ExerList(title = "MOUNTAIN CLIMBER",time = "01:30",route = CategoryRoute.ARM.name),
//    ExerList(title = "HEEL TOUCH",time = "01:45",route = CategoryRoute.ARM.name),
//    ExerList(title = "LEG RAISES",time = "01:45",route = CategoryRoute.ARM.name),
//    ExerList(title = "BICYCLE CRUNCHES",time = "01:00",route = CategoryRoute.ARM.name),
)

val ChestExerciseList = listOf(
    ExerList(title ="JUMPING JACKS", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="INCLINE PUSH-UPS", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="PUSH-UPS", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="WIDE ARM PUSH-UPS", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="TRICEPS DIPS", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="COBRA STRETCH", time ="", route = CategoryRoute.CHEST.name ),
    ExerList(title ="CHEST STRETCH", time ="", route = CategoryRoute.CHEST.name ),
    )

val ArmExerciseList = listOf(
    ExerList(title ="ARM RAISES", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="SIDE ARM RAISE", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="ARM CIRCLES CLOCKWISE", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="CHEST PRESS PULSE", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="DIAGONAL PLANK", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="WALL PUSH-UPS", time ="", route = CategoryRoute.ARM.name ),
    ExerList(title ="STANDING BIECEPS STRETCH LEFT", time ="", route = CategoryRoute.ARM.name ),

)

val LegExerciseList = listOf(
    ExerList(title ="SIDE HOP", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="SQUATS", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT RIGHT", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT LEFT", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="DONKEY KICKS RIGHT", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="DONKEY KICKS LEFT", time ="", route = CategoryRoute.LEG.name ),
    ExerList(title ="BACKWARD LUNGE", time ="", route = CategoryRoute.LEG.name ),
)

val ShoulderExerciseList = listOf(
    ExerList(title ="JUMPING JACKS", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="ARM RAISES", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="RHOMBOID PULLS", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="SIDE ARM RAISE", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="KNEE PUSH-UPS", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="CAT COW POSE", time ="", route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="CHILD'S POSE", time ="", route = CategoryRoute.SHOULDER.name ),
)