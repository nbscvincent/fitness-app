package com.nbscollege.fitnessapp.mainscreen.settingscreen


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.General

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingCard(general: General, navController: NavController) {
    Spacer(modifier = Modifier.height(5.dp))
    Card(
        modifier = Modifier
//            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        content = {
            Box(
                modifier = Modifier.fillMaxSize()

            ) {

                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(alpha = 0.1f))
                        .clickable(onClick = {
                            navController.navigate(general.route)
                        }),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Lock, // You can use any other icon
                        contentDescription = null,
                        tint = Color(0xFFE57373),
                        modifier = Modifier.padding(start = 20.dp, top = 17.dp)
                    )
                    Text(
                        general.title,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start=10.dp, top=17.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }

            }
        },
    )

    Spacer(modifier = Modifier
        .height(8.dp)
        .background(Color.White))
}
