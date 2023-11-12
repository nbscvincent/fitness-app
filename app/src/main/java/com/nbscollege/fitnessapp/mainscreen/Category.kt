package com.nbscollege.fitnessapp.mainscreen

import com.nbscollege.fitnessapp.R

data class Category(
    val title: String,
    val exerciseCount: String,
    val subTitle: String,
    val backgroundImageResourceId: Int,


)

val categoryExercise = listOf(
    Category("ABS WORKOUT", "11", "Exercise", R.drawable.abs),
    Category("CHEST WORKOUT", "11", "Exercise", R.drawable.interchest),
    Category("ARM WORKOUT", "19", "Exercise", R.drawable.arm),
    Category("LEG WORKOUT", "23", "Exercise", R.drawable.leg),
    Category("SHOULDER & BACK BEGINNER WORKOUT", "17", "Exercise", R.drawable.shoulderback),
)



