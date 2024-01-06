package com.nbscollege.fitnessapp.mainscreen.categorycard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerList

@Composable
fun SampleExerCateg (
    exer: ArrayList<ExerList>,
    chesttime: Int = 60,
    navController: NavController
) {

    var currentExer: ArrayList<ExerList> by remember {
        mutableStateOf(ArrayList())
    }

    var Nextexer by remember {
        mutableStateOf(false)
    }

    var selectedexer by remember {
        mutableStateOf(exer.first())
    }

    var progress by remember {
        mutableStateOf(1f)
    }

    var start by remember {
        mutableStateOf(false)
    }


    if (chesttime > 0) {
        chesttime - 1
        if (chesttime == 0){
            Nextexer = true
        }
    }


}