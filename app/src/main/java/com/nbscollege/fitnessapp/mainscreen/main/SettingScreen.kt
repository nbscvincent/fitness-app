package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
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

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.navigation.NavController
import com.nbscollege.fitnessapp.bottomNavBar.BottomNavBar

//enum class SelectedButton {
//    Home,
//    Person,
//    Settings
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingscreen(navController : NavController) {


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIos,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Back"
                    )
                }

                }

        },
        bottomBar = {

        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
            ) {

            }
            Column (
                
            ) {
                Text(text = "General Settings", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            }

        }



    }
}
