package com.nbscollege.fitnessapp.mainscreen.categorycard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.mainscreen.dataclass.ExerList

@Composable
fun SampleExerCateg (
    exer: ExerList,
    chesttime: Int = 60,
    navController: NavController
) {

    var currentExer: ArrayList<ExerList> by remember {
        mutableStateOf(ArrayList())
    }

    var Nextexer by remember {
        mutableStateOf(false)
    }

    var selectedexer by remember {
        mutableStateOf(exer.title)
    }

    var progress by remember {
        mutableStateOf(1f)
    }

    var start by remember {
        mutableStateOf(false)
    }


    if (chesttime > 0) {
        chesttime - 1
        if (chesttime == 0){
            Nextexer = true
        }
    }
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
        }
    )



}