package com.nbscollege.fitnessapp.mainscreen.card


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.nbscollege.fitnessapp.mainscreen.dataclass.General

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingCard(general: General, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start=20.dp, end = 20.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(16.dp)),
            elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp,
            ),
        content = {
            Box(
                modifier = Modifier.fillMaxSize()



            ) {


            Row(
                    modifier = Modifier
                        .height(45.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(alpha = 0.1f))
                        .clickable(onClick = {
                            navController.navigate(general.route)
                        }),
                ) {
                    Text(
                        general.title,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start=20.dp, top=10.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = general.icon, // Replace with the desired icon
                        modifier = Modifier
                            .padding(end = 30.dp, top = 14  .dp)
                            .size(20.dp),

                        contentDescription = "Arrow ForwardIos",
                        tint = Color.DarkGray
                    )


                }
            }



//                Divider(
//                    color = Color.LightGray,
//                    thickness = 1.dp,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding()
//                )
//                Row(
//                    modifier = Modifier
//                        .height(60.dp)
//                        .fillMaxWidth()
//                        .clickable( onClick = {
//                            navController.navigate(SettingsRoute.GeneralSettings.name)
//                        }),
//                ) {
//                    Text(
//                        text = "General Settings",
//                        color = Color.Black,
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight.Light,
//                        modifier = Modifier.padding(start=20.dp, top=10.dp)
//                    )
//                    Icon(
//                        imageVector = Icons.Default.ArrowForwardIos, // Replace with the desired icon
//                        modifier = Modifier
//                            .padding(start = 130.dp, top=15.dp)
//                            .size(25.dp),
//                                .clickable( onClick = {
//                                    navController.navigate(SettingsRoute.GeneralSettings.name)
//                                }),
//
//                        contentDescription = "Arrow ForwardIos",
//                        tint = Color.DarkGray
//                    )
//                            .clickable( onClick = {
//                                navController.navigate(Auth.OTP.name)
//
//
//
//
//
//                }
//                Divider(
//                    color = Color.LightGray,
//                    thickness = 1.dp,
//                    modifier = Modifier.fillMaxWidth().padding()
//                )



        },
    )
    Spacer(modifier = Modifier.height(8.dp).background(Color.White))
}
