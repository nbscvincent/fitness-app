package com.nbscollege.fitnessapp.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.screen

enum class SelectedButton3 {
    Home,
    Person,
    Settings,
    SplashScreen
}

@Composable
fun BottomAppBar(navController: NavController){
    var selectedButton3 by remember { mutableStateOf(SelectedButton3.Home) }

    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // HOME BUTTON
            Button(
                onClick = {
                    selectedButton3 = SelectedButton3.Home
                    navController.navigate(route = screen.HomeScreen.name)
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
            ) {

                Icon(
                    imageVector = Icons.Default.Home, contentDescription = "Home",
                    tint = if (selectedButton3 == SelectedButton3.Home) Color.Blue else Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }


            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .then(Modifier.drawWithContent {
                        // Draw a border on the right side
                        drawLine(
                            color = Color.Gray,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 1.dp.toPx()
                        )
                    }),
            )

            // PERSON BUTTON
            Button(
                onClick = {

                    selectedButton3 = SelectedButton3.Person
                    navController.navigate(route = screen.ProfileScreen.name)

                },
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
            ) {

                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Profile",
                    tint = if (selectedButton3 == SelectedButton3.Person) Color.Blue else Color.Black,
                    modifier = Modifier.size(40.dp),
                )
            }

            Box(
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .then(Modifier.drawWithContent {
                        // Draw a border on the right side
                        drawLine(
                            color = Color.Gray,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 1.dp.toPx()
                        )
                    }),
            )


            // SETTINGS BUTTON
            Button(
                onClick = {
                    selectedButton3 = SelectedButton3.Settings
                    navController.navigate(screen.SettingScreen.name)
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
            ) {

                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = if (selectedButton3 == SelectedButton3.Settings) Color.Blue else Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}