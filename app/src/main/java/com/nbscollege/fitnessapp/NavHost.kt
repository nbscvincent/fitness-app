package com.nbscollege.fitnessapp

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.ui.theme.About
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.absinter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.arminter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.backinter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.chestinter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.leginter
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.absbeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.armbeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.backbeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.chestbeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.legbeg

@Composable
    fun Nav() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home"
            ) {
            composable("Home") {
                home(navController = navController)
            }
            composable("About") {
                About(navController = navController)
            }
            composable("AbsBeg") {
                absbeg(navController = navController)
            }
            composable("ChestBeg") {
                chestbeg(navController = navController)
            }
            composable("ArmBeg") {
                armbeg(navController = navController)
            }
            composable("LegBeg") {
                legbeg(navController = navController)
            }
            composable("BackBeg") {
                backbeg(navController = navController)
            }
            composable("AbsInter") {
                absinter(navController = navController)
            }
            composable("ChestInter") {
                chestinter(navController = navController)
            }
            composable("ArmInter") {
                arminter(navController = navController)
            }
            composable("LegInter") {
                leginter(navController = navController)
            }
            composable("BackInter") {
                backinter(navController = navController)
            }
        }
    }
