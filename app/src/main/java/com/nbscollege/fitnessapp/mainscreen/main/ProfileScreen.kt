package com.nbscollege.fitnessapp.model


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.ui.user.ProfileViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
fun ProfileScreen(
    screenViewModel: ScreenViewModel,
    navController: NavController,
    viewModel: ProfileViewModel = viewModel(factory = AppViewModelProvider.Factory),
    loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)

) {
    val coroutineScope = rememberCoroutineScope()

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

        val username = remember { loginViewModel.currentUser?.username }

        // Observe the userDetails StateFlow from the ViewModel
        val user by viewModel.userDetails.collectAsState()

        LaunchedEffect(Unit) {
            username?.let {
                viewModel.loadUserDetails(it)
            }
        }

        // UI for ProfileScreen
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            // Inside ProfileScreen composable
            if (user != null) {
                // Populate UI with user details
                Text("Username: ${user!!.username}")
                Text("Weight: ${user!!.weight} kg")
                Text("Height: ${user!!.height} cm")
                // Add other user details as needed
            } else {
                // Handle the case when user details are not available
                Text("User details not available.")
            }

        }







        }
    }

//            Box(
//                modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.White),
//
//                ) {
//
//                LazyColumn(
//
//                    modifier = Modifier.padding(top = 10.dp).background(Color.White),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceBetween
//                ) {
//
//                    items(listOfNotNull(screenViewModel.currentUser.value)) { profile ->
//                        Column(
//                        ) {
//                            Text(
//                                "Username",
//                                color = Color.Black,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Card(
//                                modifier = Modifier
//                                    .padding(start = 20.dp, end = 20.dp)
//                                    .background(Color.White)
//                                    .fillMaxSize(),
//                                elevation = CardDefaults.cardElevation(
//                                    defaultElevation = 7.dp,
//                                ),
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(45.dp)
//                                        .background(Color.White)
//                                        .fillMaxWidth()
//                                        .background(Color.LightGray.copy(alpha = 0.1f))
//                                ) {
//                                    Text(
//                                        "${profile.username}",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(
//                                "Age",
//                                color = Color.Black,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Card(
//                                modifier = Modifier
//                                    .padding(start = 20.dp, end = 20.dp)
//                                    .background(Color.White)
//                                    .fillMaxSize(),
//                                elevation = CardDefaults.cardElevation(
//                                    defaultElevation = 7.dp,
//                                ),
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(45.dp)
//                                        .background(Color.White)
//                                        .fillMaxWidth()
//                                        .background(Color.LightGray.copy(alpha = 0.1f))
//                                ) {
//                                    Text(
//                                        "${profile.age}",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(
//                                "Weight",
//                                color = Color.Black,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Card(
//                                modifier = Modifier
//                                    .padding(start = 20.dp, end = 20.dp)
//                                    .background(Color.White)
//                                    .fillMaxSize(),
//                                elevation = CardDefaults.cardElevation(
//                                    defaultElevation = 7.dp,
//                                ),
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(45.dp)
//                                        .background(Color.White)
//                                        .fillMaxWidth()
//                                        .background(Color.LightGray.copy(alpha = 0.1f))
//                                ) {
//                                    Text(
//                                        "${profile.weight}",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(
//                                "Height",
//                                color = Color.Black,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Card(
//                                modifier = Modifier
//                                    .padding(start = 20.dp, end = 20.dp)
//                                    .background(Color.White)
//                                    .fillMaxSize(),
//                                elevation = CardDefaults.cardElevation(
//                                    defaultElevation = 7.dp,
//                                ),
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(45.dp)
//                                        .background(Color.White)
//                                        .fillMaxWidth()
//                                        .background(Color.LightGray.copy(alpha = 0.1f))
//                                ) {
//                                    Text(
//                                        "${profile.height}",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(
//                                "Weight",
//                                color = Color.Black,
//                                fontSize = 20.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Card(
//                                modifier = Modifier
//                                    .padding(start = 20.dp, end = 20.dp)
//                                    .background(Color.White)
//                                    .fillMaxSize(),
//                                elevation = CardDefaults.cardElevation(
//                                    defaultElevation = 7.dp,
//                                ),
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .height(45.dp)
//                                        .background(Color.White)
//                                        .fillMaxWidth()
//                                        .background(Color.LightGray.copy(alpha = 0.1f))
//                                ) {
//                                    Text(
//                                        "${profile.weight}",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                }
//                            }
//                            val height = profile.height
//                            val weight = profile.weight
//
//
//                            if (height != null && weight != null) {
//
//                                val bmi = weight / (height * height) * 10000
////                            val bmiText = String.format(Locale.getDefault(), "BMI: %.2f - $bmiCategory", bmi)
//                                val bmiCategory = when {
//                                    bmi < 18.5 -> "Underweight"
//                                    bmi < 24.9 -> "Normal Weight"
//                                    bmi < 29.9 -> "Overweight"
//                                    else -> "Obese"
//                                }
//                                // Display BMI
//                                if (bmi < 18.5) {
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "BMI",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "%.2f".format(bmi),
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//
//                                    Spacer(modifier = Modifier.height(10.dp))
//
//                                    Text(
//                                        "Category",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "$bmiCategory",
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                ),
//                                            )
//                                        }
//                                    }
//
//
//                                    Text(
//                                        "Tips: Try to avoid foods with a lot of added sugar, fat and salt, like cakes, takeaway foods and sugary drinks. You can put on weight by eating small meals frequently throughout the day. Try to snack on healthy, high energy foods like cheese, nuts, milk-based smoothies and dried fruit.",
//                                        color = Color.Red,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
//                                    )
//                                } else if (bmi < 24.5) {
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Row(
//
//                                    ) {
//                                        Text(
//                                            "BMI",
//                                            color = Color.Black,
//                                            fontSize = 20.sp,
//                                            fontWeight = FontWeight.Bold,
//                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//
//                                        )
//
////                                        Icon(
////                                            imageVector = Icons.Rounded.Edit,
////                                            modifier = Modifier.size(30.dp)
////                                                .padding(top=15.dp)
////                                                .clickable( onClick = {
////
////                                                }
////                                                ),
////                                            contentDescription = "Edit",
////                                            tint = Color.DarkGray
////                                        )
//
//
//                                    }
//
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .fillMaxSize()
//                                            .background(Color.White),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "%.2f".format(bmi),
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Category",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "$bmiCategory",
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Please Maintain",
//                                        color = Color.Red,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
//                                    )
//                                } else if (bmi < 29.9) {
//
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "BMI",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "%.2f".format(bmi),
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Category",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "$bmiCategory",
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Tips: eat a balanced, calorie-controlled diet as recommended by your GP or weight loss management health professional (such as a dietitian) join a local weight loss group. take up activities such as fast walking, jogging, swimming or tennis for 150 to 300 minutes (two-and-a-half to five hours) a week.",
//                                        color = Color.Red,
//                                        fontSize = 30.sp,
//                                        modifier = Modifier.padding(start = 40.dp, top = 10.dp)
//                                    )
//                                } else {
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "BMI",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "%.2f".format(bmi),
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//
//
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Category",
//                                        color = Color.Black,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//                                    Spacer(modifier = Modifier.height(5.dp))
//                                    Card(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp, end = 20.dp)
//                                            .background(Color.White)
//                                            .fillMaxSize(),
//                                        elevation = CardDefaults.cardElevation(
//                                            defaultElevation = 7.dp,
//                                        ),
//                                    ) {
//                                        Box(
//                                            modifier = Modifier
//                                                .height(45.dp)
//                                                .background(Color.White)
//                                                .fillMaxWidth()
//                                                .background(Color.LightGray.copy(alpha = 0.1f))
//                                        ) {
//                                            Text(
//                                                "$bmiCategory",
//                                                color = Color.Black,
//                                                fontSize = 20.sp,
//                                                fontWeight = FontWeight.Bold,
//                                                modifier = Modifier.padding(
//                                                    start = 20.dp,
//                                                    top = 10.dp
//                                                )
//                                            )
//                                        }
//                                    }
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        "Tips: ",
//                                        color = Color.Red,
//                                        fontSize = 20.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                    )
//
//
//                                }
//
////                            Text(
////                                "BMI: %.2f".format(bmi),
////                                color = Color.Black,
////                                fontSize = 30.sp,
////                                fontWeight = FontWeight.Thin,
////                                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
////                            )
////                            Text(
////                                "Category: $bmiCategory",
////                                color = Color.Black,
////                                fontSize = 30.sp,
////                                fontWeight = FontWeight.Thin,
////                                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
////                            )
//                            } else {
//                                Spacer(modifier = Modifier.height(10.dp))
//                                Text(
//                                    "BMI",
//                                    color = Color.Black,
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                )
//                                Spacer(modifier = Modifier.height(5.dp))
//                                Card(
//                                    modifier = Modifier
//                                        .padding(start = 20.dp, end = 20.dp)
//                                        .background(Color.White)
//                                        .fillMaxSize(),
//                                    elevation = CardDefaults.cardElevation(
//                                        defaultElevation = 7.dp,
//                                    ),
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .height(45.dp)
//                                            .background(Color.White)
//                                            .fillMaxWidth()
//                                            .background(Color.LightGray.copy(alpha = 0.1f))
//                                    ) {
//                                        Text(
//                                            "Invalid height or weight",
//                                            color = Color.Red, // or any color you prefer for error messages
//                                            fontSize = 20.sp,
//                                            fontWeight = FontWeight.Bold,
//                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
//                                        )
//                                    }
//                                }
//                                // Handle the case where height or weight couldn't be converted to numbers
//
//                            }
//
//                        }
//
//                    }
//                }
//            }





