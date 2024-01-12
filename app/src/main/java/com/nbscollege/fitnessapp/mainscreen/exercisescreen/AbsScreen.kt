package com.nbscollege.fitnessapp.mainscreen.exercisescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerciseList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsScreen(navController: NavController, index: Int) {

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
//                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {

                SmallFloatingActionButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .zIndex(3f)

                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft, "Back",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.abs),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                )
            }
        },
        bottomBar = {
            BottomAppBar (modifier = Modifier.height(150.dp)) {


                Button(
                    modifier = Modifier.fillMaxWidth().height(150.dp),

                    onClick = {}
                ) {
                    Text("Start")
                }

            }
        }
    ) { innerPadding ->
        // Content of your screen goes here

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

//                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(
                    modifier = Modifier.padding(0.dp),

                ) {

                    item {
                        Text(
                            text = ExerciseList[index].title,
                            fontWeight = FontWeight.Bold,

                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )
                        Text(
                            text = "${ExerciseList[index].time} seconds",
                            fontWeight = FontWeight.Bold,

                            textAlign = TextAlign.Center,
                            color = Color(0xFF6562DF),
                        )


                    }



                }
            }

        }
    }

    }


