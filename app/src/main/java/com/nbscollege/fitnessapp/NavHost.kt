package com.nbscollege.fitnessapp

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.absinter
import com.nbscollege.fitnessapp.ui.theme.ExerciseInter.chestinter
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.absbeg
import com.nbscollege.fitnessapp.ui.theme.model.ExerciseBeg.chestbeg


@Composable
    fun Nav() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home",
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(900)
                )

            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(900)
                )
            }) {
            composable("login") {
                home(navController = navController)
            }
            composable("signup") {
                absbeg(navController = navController)
            }
            composable("verify") {
                chestbeg(navController = navController)
            }
            composable("signup") {
                absinter(navController = navController)
            }
            composable("verify") {
                chestinter(navController = navController)
            }
        }
    }
