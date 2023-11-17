package com.nbscollege.fitnessapp.mainscreen.exercisescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsScreen(navController: NavController) {

    Scaffold(
        topBar = {

            Box(
                modifier = Modifier
                    .height(180.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {

                Image(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    painter = painterResource(id = R.drawable.abs),
                    contentScale = ContentScale.Crop,
                    contentDescription = "NBS LOGO",
                )

                Text(
                    text = "ABS Workout",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)

                )

            }
        },


        bottomBar = {
            BottomAppBar {

            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
            ) {
                items(20) { index ->
                    Text("I'm item $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
                }
            }
        }






        }

    }


