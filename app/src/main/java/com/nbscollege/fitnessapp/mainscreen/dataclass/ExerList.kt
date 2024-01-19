package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class ExerList(
    val title: String,
    val animation: Float,
    val time: Int,
    val route:String
)

val ExerciseList = listOf(
    //for abs workout
    ExerList(title = "PLANK", R.raw.plank.toFloat(), time = 60, route = CategoryRoute.ABS.name),
    ExerList(title = "ABDOMINAL CRUNCHES", R.raw.abdominal.toFloat(), time = 60,route = CategoryRoute.ABS.name),
    ExerList(title = "RUSSIAN TWIST", R.raw.russian.toFloat(), time = 120,route = CategoryRoute.ABS.name),
    ExerList(title = "BURPEES", R.raw.burpee.toFloat(), time = 90,route = CategoryRoute.ABS.name),
    ExerList(title = "LEG RAISES", R.raw.leg.toFloat(), time = 45,route = CategoryRoute.ABS.name),
    ExerList(title = "SQUATS", R.raw.squats.toFloat(), time = 30,route = CategoryRoute.ABS.name),
    ExerList(title = "FLUTTER KICKS", R.raw.flutter.toFloat(), time = 90,route = CategoryRoute.ABS.name),

)

val ChestExerciseList = listOf(
    ExerList(title ="JUMPING JACKS", R.raw.jumping.toFloat(), time =90, route = CategoryRoute.CHEST.name ),
    ExerList(title ="DECLINE PUSH-UPS", R.raw.declinepush.toFloat(), time =60, route = CategoryRoute.CHEST.name ),
    ExerList(title ="PUSH-UPS", R.raw.pushup.toFloat(), time =60, route = CategoryRoute.CHEST.name ),
    ExerList(title ="WIDE ARM PUSH-UPS", R.raw.widepush.toFloat(), time =60, route = CategoryRoute.CHEST.name ),
    ExerList(title ="TRICEPS DIPS", R.raw.tricepsdip.toFloat(), time =120, route = CategoryRoute.CHEST.name ),
    ExerList(title ="COBRA STRETCH", R.raw.cobrastretch.toFloat(), time =60, route = CategoryRoute.CHEST.name ),
    ExerList(title ="CHEST STRETCH", R.raw.cheststretch.toFloat(),  time =60, route = CategoryRoute.CHEST.name ),
    )

val ArmExerciseList = listOf(
    ExerList(title ="ARM RAISES", R.raw.armraises.toFloat(),  time =60, route = CategoryRoute.ARM.name ),
    ExerList(title ="SIDE ARM RAISE", R.raw.sidearm.toFloat(),  time =60, route = CategoryRoute.ARM.name ),
    ExerList(title ="ARM CIRCLES BACKWARDS",  R.raw.armcircles.toFloat(), time =90, route = CategoryRoute.ARM.name ),
    ExerList(title ="CHEST PRESS", R.raw.chestpress.toFloat(),  time =90, route = CategoryRoute.ARM.name ),
    ExerList(title ="PLANK JACKS", R.raw.plankjack.toFloat(),  time =90, route = CategoryRoute.ARM.name ),
    ExerList(title ="BENCH PRESS", R.raw.benchpress.toFloat(),  time =60, route = CategoryRoute.ARM.name ),
    ExerList(title ="REVERSE CURL", R.raw.reversecurl.toFloat(),  time =60, route = CategoryRoute.ARM.name ),

)

val LegExerciseList = listOf(
    ExerList(title ="BOX JUMPS", R.raw.boxjumps.toFloat(),  time =60, route = CategoryRoute.LEG.name ),
    ExerList(title ="SQUATS",  R.raw.squats.toFloat(), time =30, route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT RIGHT", R.raw.legliftright.toFloat(),  time =30, route = CategoryRoute.LEG.name ),
    ExerList(title ="SIDE-LYING LEG LIFT LEFT", R.raw.legliftleft.toFloat(),  time =30, route = CategoryRoute.LEG.name ),
    ExerList(title ="ALTERNATE ARM AND LEG PLANK",  R.raw.alternateplank.toFloat(), time =120, route = CategoryRoute.LEG.name ),
    ExerList(title ="STANDING BOW HAMSTRING STRETCH", R.raw.hamstring.toFloat(),  time =60, route = CategoryRoute.LEG.name ),
    ExerList(title ="HIGH KNEES",  R.raw.highknees.toFloat(), time =90, route = CategoryRoute.LEG.name ),
)

val ShoulderExerciseList = listOf(
    ExerList(title ="JUMPING JACKS",  R.raw.jumping.toFloat(), time =90, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="ARM RAISES", R.raw.armraises.toFloat(),  time =60, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="LATERAL RAISES",  R.raw.lateralraises.toFloat(), time =60, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="SIDE ARM RAISE",  R.raw.sidearm.toFloat(), time =60, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="PUSH-UPS AND ROTATION", R.raw.pushuprotation.toFloat(),  time =90, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="SHOULDER PRESS SIT-UPS",  R.raw.shoulderpress.toFloat(), time =120, route = CategoryRoute.SHOULDER.name ),
    ExerList(title ="PIKE PUSH-UPS", R.raw.pikepush.toFloat(),  time =90, route = CategoryRoute.SHOULDER.name ),
)