package com.nbscollege.fitnessapp.mainscreen.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.navigation.CategoryRoute
@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val exerciseCount: String,
    val subTitle: String,
    val backgroundImageResourceId: Int,
    val route: String,
)


val categoryExercise = listOf(
    Category("ABS WORKOUT", "7", "Exercise", R.drawable.abs, CategoryRoute.ABS.name, ),
    Category("CHEST WORKOUT", "11", "Exercise", R.drawable.interchest, CategoryRoute.CHEST.name,  ),
    Category("ARM WORKOUT", "19", "Exercise", R.drawable.arm, CategoryRoute.ARM.name, ),
    Category("LEG WORKOUT", "23", "Exercise", R.drawable.leg, CategoryRoute.LEG.name, ),
    Category("SHOULDER & BACK WORKOUT", "17", "Exercise", R.drawable.shoulderback, CategoryRoute.SHOULDER.name),
)



