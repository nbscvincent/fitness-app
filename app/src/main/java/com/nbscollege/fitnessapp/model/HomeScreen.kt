package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.BadgeDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

class HomeScreen {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homescreen() {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Text(
                        text = "FITNESS WORKOUT",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .graphicsLayer(translationY = 70f, translationX = 30f)

                    )
                        text = "Beginner",
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .graphicsLayer(translationY = 290f, translationX = 30f)
                    )
                }
            }
        )
        {
            Column(modifier = Modifier.padding(top = 180.dp)
                .background(Color.White)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().background(Color.White),
                    contentAlignment = Alignment.Center

                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {

                            Button( modifier = Modifier.fillMaxSize().height(70.dp),

                                onClick = { },
                                shape = RoundedCornerShape(20.dp),
                                ) {
                                Text(
                                    "JUMPING JACKS",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                )
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(1.dp),
                            ) {
                                Text(
                                    "ABDOMINAL CRUNCHES",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp


                                )
                            }

                        }

                    }
                }
            }
        }
    }
}


