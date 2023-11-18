package com.nbscollege.fitnessapp.mainscreen.card


import android.annotation.SuppressLint
import androidx.compose.foundation.background
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

import androidx.compose.foundation.layout.size

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Settings

import androidx.compose.material.icons.outlined.Settings


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

import com.nbscollege.fitnessapp.navigation.SettingsRoute

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingCard(general: General, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            ,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        content = {
                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .clickable(onClick = {

                            navController.navigate(SettingsRoute.Settings.name)
                        }),
                ) {
                    Text(
                        general.title,
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Thin,
                        modifier = Modifier.padding(start=40.dp, top=10.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = general.icon, // Replace with the desired icon
                        modifier = Modifier
                            .padding(end = 50.dp, top = 20.dp)
                            .size(20.dp),

                        contentDescription = "Arrow ForwardIos",
                        tint = Color.DarkGray
                    )


                }
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                )
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
}
