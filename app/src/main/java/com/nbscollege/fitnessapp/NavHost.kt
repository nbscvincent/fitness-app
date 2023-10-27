package com.nbscollege.fitnessapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun Nav() {
    val navController = rememberNavController()

    var isPerson by remember { mutableStateOf(true) }
    var isHome by remember { mutableStateOf(true) }
    var isSettings by remember { mutableStateOf(true) }
    Scaffold(

        bottomBar = { Navibottom(navController = navController) },
    ) {


        NavHost(
            navController = navController, startDestination = "Home"
        ) {
//            composable("LogIn") {
//                LOGIN(navController = navController)
//            }
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
}