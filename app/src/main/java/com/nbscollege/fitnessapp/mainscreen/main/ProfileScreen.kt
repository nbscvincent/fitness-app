package com.nbscollege.fitnessapp.model


import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.authscreen.model.LoggedInUserHolder
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.ui.user.ProfileViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition",
    "StateFlowValueCalledInComposition"
)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
fun ProfileScreen(
    screenViewModel: ScreenViewModel,
    navController: NavController,
    viewModel: ProfileViewModel = viewModel(factory = AppViewModelProvider.Factory),
    loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)

) {
    val coroutineScope = rememberCoroutineScope()

    val loggedInUser = LoggedInUserHolder.getLoggedInUser()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .background(Color.White)
                    .height(100.dp)
                    .fillMaxWidth()

            ) {

                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Outlined.Person,
                            modifier = Modifier.size(45.dp),
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "Profile",
                            color = Color.Black,
                            fontSize = 38.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(),
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    ) { innerPadding ->
        Card(
            content  = {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(innerPadding).background(color = Color.White)
                ) {

                    item {
                        loggedInUser?.let {

                            Text(
                                text = "Username: ${it.username}",
                                style = TextStyle(fontSize = 20.sp),
                                modifier = Modifier.padding(8.dp)
                            )

                            Text(
                                text = "Weight: ${it.weight}",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(8.dp)
                            )


                            Text(
                                text = "Height: ${it.height}",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(8.dp)
                            )



                            Text(
                                text = "Age: ${it.age}",
                                style = TextStyle(fontSize = 16.sp),
                                modifier = Modifier.padding(8.dp)
                            )

                        } ?: run {
                            Text(
                                text = "User not logged in",
                                style = TextStyle(fontSize = 20.sp),
                                color = Color.Red
                            )
                        }
                    }




                }
            }
        )












        }
    }





