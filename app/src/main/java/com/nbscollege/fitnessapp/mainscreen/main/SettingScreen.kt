package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.settingsList
import com.nbscollege.fitnessapp.mainscreen.settingscreen.SettingCard
import com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard.SettingCardRateUs
import com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard.SettingCardWithLogoutDialog
import com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard.SettingCardWithSendFeedbackDialog


//enum class SelectedButton {
//    Home,
//    Person,
//    Settings
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingscreen(context: Context, navController: NavController) {

    var isLogoutDialogVisible by remember { mutableStateOf(false) }
    var isSendFeedBackDialogVisible by remember { mutableStateOf(false) }
    var isRateUs by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .padding(top = 10.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {

                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
//                    IconButton(onClick = { navController.navigateUp() }) {
//                        Icon(
//                            imageVector = Icons.Rounded.ArrowBackIos,
//                            modifier = Modifier.size(30.dp),
//                            contentDescription = "Back",
//                            tint = Color.DarkGray
//                        )
//                    }
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            modifier = Modifier.size(45.dp),
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "Settings",
                            color = Color.Black,
                            fontSize = 38.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(),
                        )
                    }
                }

            }
        },
        bottomBar =

        {

            BottomAppBar{

            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),

            ) {

            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween

            ) {

                items(settingsList) { general ->
                    when (general.title) {
                        "Log out" -> {
                            SettingCardWithLogoutDialog(
                                general = general,
                                navController,
                                isLogoutDialogVisible
                            ) {
                                isLogoutDialogVisible = it
                            }
                        }
                        "Send Feedback" -> {
                            SettingCardWithSendFeedbackDialog(
                                general = general,
                                context = LocalContext.current,
                                navController,
                                isSendFeedBackDialogVisible
                            ) {
                                isSendFeedBackDialogVisible = it
                            }
                        }
                        "Rate Us" -> {
                            SettingCardRateUs(
                                general = general,
                                context = LocalContext.current,
                                navController,

                                isRateUs
                            ) {
                                isRateUs = it
                            }
                        }

                        else -> {
                            SettingCard(general = general, navController)
                        }
                    }
                }
            }


        }
    }
}



