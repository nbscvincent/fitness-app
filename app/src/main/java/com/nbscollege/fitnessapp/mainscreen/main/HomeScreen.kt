package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nbscollege.fitnessapp.mainscreen.categorycard.CategoryCard
import com.nbscollege.fitnessapp.mainscreen.dataclass.categoryExercise


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homescreen(navController: NavHostController,) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
//                    .height(50.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "FITNESS WORKOUT",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
                )
            }
        },
        bottomBar =

                {

         BottomAppBar{

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
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {

                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "CATEGORY EXERCISE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }
                    items(categoryExercise) { category ->
                        CategoryCard(category = category, navController)
                    }


                }
            }

        }
    }

}





