package com.nbscollege.fitnessapp.mainscreen.dataclass

import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute

data class Category(
    val title: String,
    val exerciseCount: String,
    val subTitle: String,
    val backgroundImageResourceId: Int,
    val route: String
)

data class ExerList(
    val title: String,
    val timer: String,

)

val categoryExercise = listOf(
    Category("ABS WORKOUT", "", "Exercise", R.drawable.abs, CategoryRoute.ABS.name),
    Category("CHEST WORKOUT", "11", "Exercise", R.drawable.interchest, CategoryRoute.CHEST.name ),
    Category("ARM WORKOUT", "19", "Exercise", R.drawable.arm, CategoryRoute.ARM.name),
    Category("LEG WORKOUT", "23", "Exercise", R.drawable.leg, CategoryRoute.LEG.name),
    Category("SHOULDER & BACK WORKOUT", "17", "Exercise", R.drawable.shoulderback, CategoryRoute.SHOULDER.name),
)



