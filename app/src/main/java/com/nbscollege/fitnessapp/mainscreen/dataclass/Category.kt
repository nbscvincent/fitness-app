package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class Category(
    val title: String,
    val exerciseCount: String,
    val subTitle: String,
    val backgroundImageResourceId: Int,
    val route: String,
    val exerList: List<ExerList>
)

val categoryExercise = listOf(
    Category("ABS WORKOUT", "11", "Exercise", R.drawable.abs, CategoryRoute.ABS.name, ExerciseList),
    Category("CHEST WORKOUT", "11", "Exercise", R.drawable.interchest, CategoryRoute.CHEST.name, ExerciseList ),
    Category("ARM WORKOUT", "19", "Exercise", R.drawable.arm, CategoryRoute.ARM.name, ExerciseList),
    Category("LEG WORKOUT", "23", "Exercise", R.drawable.leg, CategoryRoute.LEG.name, ExerciseList),
    Category("SHOULDER & BACK WORKOUT", "17", "Exercise", R.drawable.shoulderback, CategoryRoute.SHOULDER.name, ExerciseList),
)



