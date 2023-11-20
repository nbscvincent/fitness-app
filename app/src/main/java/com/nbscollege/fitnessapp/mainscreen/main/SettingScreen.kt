package com.nbscollege.fitnessapp.model

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.core.content.ContextCompat
import androidx.navigation.NavBackStackEntry


//enum class SelectedButton {
//    Home,
//    Person,
//    Settings
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingscreen(context: Context, navController: NavController, backStackEntry: NavBackStackEntry) {


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .padding(top=10.dp)
                    .background(Color.White)
                    .fillMaxWidth()

            ) {

                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                     IconButton(onClick = { navController.navigateUp() }) {
                         Icon(
                             imageVector = Icons.Rounded.ArrowBackIos,
                             modifier = Modifier.size(30.dp),
                             contentDescription = "Back",
                             tint = Color.DarkGray
                         )
                     }
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
                            tint = Color.DarkGray
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "Settings",
                            color = Color.DarkGray,
                            fontSize = 38.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end=45.dp),
                        )
                    }
                }

            }
        },
        bottomBar = {

        }
    ) { innerPadding ->

        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.White),

        ) {

            LazyColumn(
                modifier = Modifier.padding(top=10.dp).background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween

            ) {

                items(settingsList) { general ->
                        SettingCard(general = general, navController)

                }
            }
        }

        val recipient = "cevangelista@student.nbscollege.edu.ph"
        val subject = "Feedback on Your App"
        val openAlertDialog = remember { mutableStateOf(true) }
        var showFeedbackDialog by remember { mutableStateOf(false) }


        if (openAlertDialog.value) {
            AlertDialog(
                onDismissRequest = { openAlertDialog.value = false },
                title = { Text("Confirmation") },
                text = { Text("Would you like to send feedback via your email app?") },
                confirmButton = {
                    Button(onClick = {
                        // Navigate the user to their email app
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:$recipient")
                            putExtra(Intent.EXTRA_SUBJECT, subject)
                        }
                        ContextCompat.startActivity(context, intent, null)
                        openAlertDialog.value = false
                    }) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        // Handle dismissal if needed
                        openAlertDialog.value = false
                    }) {
                        Text("No")
                    }
                }
            )
        }


    }
}



