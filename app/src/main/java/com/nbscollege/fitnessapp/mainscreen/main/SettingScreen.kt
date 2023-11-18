package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.card.SettingCard
import com.nbscollege.fitnessapp.mainscreen.dataclass.settingsList
import androidx.compose.foundation.layout.*
import com.nbscollege.fitnessapp.mainscreen.dataclass.General


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
                    .padding(top=10.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIos,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Back",
                        tint = Color.DarkGray
                    )
                }

                }
        },
        bottomBar = {

        }
    ) { innerPadding ->

        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.White),

        ) {

        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Settings ,
                modifier = Modifier.size(45.dp),
                contentDescription = "Back",
                tint = Color.DarkGray
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                "Settings",
                color = Color.DarkGray,
                fontSize = 38.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

            LazyColumn(
                modifier = Modifier.padding(top=100.dp).background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween

            ) {

                items(settingsList) { general ->
                        SettingCard(general = general, navController)
                }


            }
        }

    }
}














//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Icon(
//                            imageVector = Icons.Outlined.Settings,
//                            modifier = Modifier.size(45.dp),
//                            contentDescription = "Back"
//                    )
//                    Spacer(modifier = Modifier.width(5.dp))
//                    Text(
//                        text = "Settings",
//                        color = Color.Black,
//                        fontSize = 38.sp,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                }
//                Spacer(modifier = Modifier.height(20.dp))
//                Row(
//                    modifier = Modifier
//                        .height(60.dp)
//                        .fillMaxWidth()
//                        .clickable( onClick = {
//                            navController.navigate(SettingsRoute.GeneralSettings.name)
//                        }),
//                ) {
//                    Text(
//                            text = "General Settings",
//                    color = Color.Black,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Light,
//                        modifier = Modifier.padding(start=20.dp, top=10.dp)
//                    )
//                        Icon(
//                            imageVector = Icons.Default.ArrowForwardIos, // Replace with the desired icon
//                            modifier = Modifier
//                                .padding(start = 130.dp, top=15.dp)
//                                .size(25.dp),
////                                .clickable( onClick = {
////                                    navController.navigate(SettingsRoute.GeneralSettings.name)
////                                }),
//
//                            contentDescription = "Arrow ForwardIos",
//                            tint = Color.DarkGray
//                        )
////                            .clickable( onClick = {
////                                navController.navigate(Auth.OTP.name)
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
//
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
////                                .clickable( onClick = {
////                                    navController.navigate(SettingsRoute.GeneralSettings.name)
////                                }),
//
//                        contentDescription = "Arrow ForwardIos",
//                        tint = Color.DarkGray
//                    )
////                            .clickable( onClick = {
////                                navController.navigate(Auth.OTP.name)
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
////                                .clickable( onClick = {
////                                    navController.navigate(SettingsRoute.GeneralSettings.name)
////                                }),
//
//                        contentDescription = "Arrow ForwardIos",
//                        tint = Color.DarkGray
//                    )
////                            .clickable( onClick = {
////                                navController.navigate(Auth.OTP.name)
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

