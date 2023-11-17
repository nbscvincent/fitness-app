package com.nbscollege.fitnessapp.mainscreen.card


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExerCateg(
    exer: ExerList, navController: NavController
) {

//    Scaffold(
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .height(180.dp)
//                    .background(Color.White)
//                    .fillMaxWidth()
//            ) {

//                SmallFloatingActionButton(
//                    onClick = {
//                        navController.navigate("HomeScreen")
//                    },
//                    containerColor = Color.Transparent,
//                    modifier = Modifier
//                        .padding(start = 5.dp, end = 5.dp)
//                        .zIndex(1f)
//
//                ) {
//                    Icon(Icons.Filled.KeyboardArrowLeft, "Back", modifier = Modifier.size(40.dp))
//                }

//                Image(
//                    modifier = Modifier.fillMaxWidth().height(180.dp),
//                    painter = painterResource(id = category.backgroundImageResourceId),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "NBS LOGO",
//                )

//                Text(
//                    text = "ABS Workout",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 25.sp,
//                    color = Color.Black,
//                    modifier = Modifier.graphicsLayer(translationY = 25f, translationX = 30f)
//
//                )

//            }
//        },
//
//
//        bottomBar = {
//            BottomAppBar {
//
//            }
//        }
//    ) { innerPadding ->
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    // Background image

                    Button(
                        onClick = {
                            navController.navigate(exer.route)
                        },
                        shape = RoundedCornerShape(1.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .height(90.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )

                    ) {

                        // Content overlay
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(1.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                exer.title,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Row(

                            ) {
                                Text(
                                    exer.time,
                                    color = Color.Black,
                                    fontSize = 16.sp
                                )


                            }

                        }
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding()
                    )
                }

            },
        )



}
