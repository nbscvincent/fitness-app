package com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard

import android.content.Context
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
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.General
import com.nbscollege.fitnessapp.mainscreen.settingscreen.settingdialog.SendFeedbackDialog

@Composable
fun SettingCardWithSendFeedbackDialog(
    general: General,
    context: Context,
    navController: NavController,
    isDialogVisible: Boolean,
    onDialogDismiss: (Boolean) -> Unit
) {

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
                            if (!isDialogVisible) {
                                onDialogDismiss(true)
                            }
                        }),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Feedback, // You can use any other icon
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

    if (isDialogVisible) {
        SendFeedbackDialog(onDismiss = { onDialogDismiss(false) }) {
            // Handle the logic for sending feedback
            onDialogDismiss(false)
            sendFeedback(navController,context)
        }
    }
}