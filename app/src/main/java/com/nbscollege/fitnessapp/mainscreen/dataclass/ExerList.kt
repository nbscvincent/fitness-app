package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class ExerList(
    val title: String,
    val animation: Int,
    val time: Int,
    val route:String
)

val ExerciseList = listOf(
    //for abs workout
    ExerList(title = "PLANK", R.raw.plank, time = 45, route = CategoryRoute.ABS.name),
    ExerList(title = "ABDOMINAL CRUNCHES", R.raw.abdominal, time = 60,route = CategoryRoute.ABS.name),
    ExerList(title = "RUSSIAN TWIST", R.raw.russian, time = 160,route = CategoryRoute.ABS.name),
    ExerList(title = "BURPEES", R.raw.burpee, time = 70,route = CategoryRoute.ABS.name),
    ExerList(title = "LEG RAISES", R.raw.leg, time = 50,route = CategoryRoute.ABS.name),
    ExerList(title = "LUNGES", R.raw.lunges, time = 30,route = CategoryRoute.ABS.name),
    ExerList(title = "FLUTTER KICKS", R.raw.flutter, time = 40,route = CategoryRoute.ABS.name),

)

val ChestExerciseList = listOf(
    ExerList(title ="JUMPING JACKS", R.raw.jumping, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="DECLINE PUSH-UPS", R.raw.declinepush, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="PUSH-UPS", R.raw.pushup, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="WIDE ARM PUSH-UPS", R.raw.widepush, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="TRICEPS DIPS", R.raw.tricepsdip, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="COBRA STRETCH", R.raw.plank, time =0, route = CategoryRoute.CHEST.name ),
    ExerList(title ="CHEST STRETCH", R.raw.cheststretch,  time =0, route = CategoryRoute.CHEST.name ),
    )

val ArmExerciseList = listOf(
    ExerList(title ="ARM RAISES", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="SIDE ARM RAISE", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="ARM CIRCLES CLOCKWISE",  R.raw.plank, time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="CHEST PRESS PULSE", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="DIAGONAL PLANK", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="WALL PUSH-UPS", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),
    ExerList(title ="STANDING BICEPS STRETCH LEFT", R.raw.plank,  time =0, route = CategoryRoute.ARM.name ),

)

val LegExerciseList = listOf(
    ExerList(title ="SIDE HOP", R.raw.plank,  time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="SQUATS",  R.raw.plank, time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT RIGHT", R.raw.plank,  time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT LEFT", R.raw.plank,  time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="DONKEY KICKS RIGHT",  R.raw.plank, time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="DONKEY KICKS LEFT", R.raw.plank,  time =0, route = CategoryRoute.LEG.name ),
    ExerList(title ="BACKWARD LUNGE",  R.raw.plank, time =0, route = CategoryRoute.LEG.name ),
)

val ShoulderExerciseList = listOf(
    ExerList(title ="JUMPING JACKS",  R.raw.plank, time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="ARM RAISES", R.raw.plank,  time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="RHOMBOID PULLS",  R.raw.plank, time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="SIDE ARM RAISE",  R.raw.plank, time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="KNEE PUSH-UPS", R.raw.plank,  time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="CAT COW POSE",  R.raw.plank, time =0, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="CHILD'S POSE", R.raw.plank,  time =0, route = CategoryRoute.SHOULDER.name ),
)