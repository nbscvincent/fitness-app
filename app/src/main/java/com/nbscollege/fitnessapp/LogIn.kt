package com.nbscollege.fitnessapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LOGIN() {


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier

            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "                      " +
                    "                      " +
                    "                      ",
            fontSize = 40.sp,
            color = Color.Black,
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = painterResource(id = R.drawable.logo).toString(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
        )

        Text(
            text = "Welcome back", fontWeight = FontWeight.Bold,
            color = Color.Black, fontSize = 38.sp
        )
        Text(
            text = "sign in to access your account",
            color = Color.Black, fontSize = 19.sp
        )
        Text(
            text = "                      ",
            fontSize = 40.sp,
            color = Color.Black,
        )
        // forda email textbox
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            }
        )
        Text(
            text = "                      ",
            fontSize = 15.sp,
            color = Color.Black,
        )
        // forda password textbox
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            }
        )
// forda chechbox
        Row(
            modifier = Modifier
                .padding(start = 0.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                modifier = Modifier.size(30.dp),
                checked = rememberMe,
                onCheckedChange = { checked ->
                    rememberMe = checked
                }
            )
            Text(
                text = "Remember Me",
                fontSize = 10.sp,
                color = Color.Black,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextButton(
                    modifier = Modifier.padding(start = 110.dp),
                    onClick = { },
                ) {
                    Text("Forgot Password? ", color = Color.Red, fontSize = 10.sp)
                }

            }
        }
        Text(
            text = "                      " +
                    "                      " +
                    "                      ",
            fontSize = 45.sp,
            color = Color.Black,
        )
        Text(
            text = "                      " +
                    "                      " +
                    "                      ",
            fontSize = 45.sp,
            color = Color.Black,
        )
        Text(
            text = "                      " +
                    "                      " +
                    "                      ",
            fontSize = 45.sp,
            color = Color.Black,
        )
        Text(
            text = "                      " +
                    "                      " +
                    "                      ",
            fontSize = 45.sp,
            color = Color.Black,
        )


        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    "                      Next  >                      ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Text(
                text = "                      ",
                fontSize = 13.sp,
                color = Color.Black,
            )
            Row(
                modifier = Modifier
                    .padding(start = 1.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "New Member?",
                    fontSize = 17.sp,
                    color = Color.Black,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(
                        modifier = Modifier.padding(start = 1.dp),
                        onClick = { },
                    ) {
                        Text("Register now", color = Color.Red, fontSize = 17.sp)
                    }

                }
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 0.dp)
            .fillMaxSize()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "                      ",
            fontSize = 13.sp,
            color = Color.Black,
        )
        Text(
            text = " < ",
            fontSize = 50.sp,
            color = Color.Black,
        )
    }
}