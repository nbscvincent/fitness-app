package com.nbscollege.fitnessapp.mainscreen.exercisescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.R
import com.nbscollege.fitnessapp.mainscreen.categorycard.ExerCateg
import com.nbscollege.fitnessapp.mainscreen.dataclass.ArmExerciseList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArmScreen(navController: NavController, backStackEntry: NavBackStackEntry) {
//    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
//                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {

//                IconButton(onClick = { navController.navigateUp() }) {
//                    Icon(
//                        imageVector = Icons.Rounded.ArrowBackIos,
//                        modifier = Modifier
//                            .size(30.dp)
//                            .padding(start = 5.dp, end = 5.dp)
//                            .zIndex(3f),
//                        contentDescription = "Back",
//                        tint = Color.White
//                    )
//                }
                SmallFloatingActionButton(
                    onClick = {
                        navController.navigate("HomeScreen")
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
                    painter = painterResource(id = R.drawable.arm),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                )
            }
        },
//        bottomBar = {
//            BottomAppBar {
//
//            }
//        }
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
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "EXERCISES",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }

                    items(ArmExerciseList) { ExerList ->
                        ExerCateg(exer = ExerList, navController)
                    }

                }
            }

        }
    }
}