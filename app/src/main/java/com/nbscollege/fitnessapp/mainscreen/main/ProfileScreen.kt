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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                    .padding(top = 5.dp)
                    .background(Color.White)
                    .height(75.dp)
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


        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)


        ) {

                    LazyColumn(
                        modifier = Modifier
                            .height(790.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding()
                            .clip(RoundedCornerShape(32.dp))
                    ) {

                        item {
                            loggedInUser?.let { user ->

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    "Username",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(start = 20.dp, end = 20.dp)
                                        .background(Color.White)
                                        .fillMaxSize(),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 7.dp,
                                    ),
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(Color.White)
                                            .fillMaxWidth()
                                            .background(Color.LightGray.copy(alpha = 0.1f))
                                    ) {
                                        Text(
                                            user.username,
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(
                                                start = 20.dp,
                                                top = 10.dp
                                            ),
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    "Age",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(start = 20.dp, end = 20.dp)
                                        .background(Color.White)
                                        .fillMaxSize(),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 7.dp,
                                    ),
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(Color.White)
                                            .fillMaxWidth()
                                            .background(Color.LightGray.copy(alpha = 0.1f))
                                    ) {
                                        Text(
                                            "${user.age}",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(
                                                start = 20.dp,
                                                top = 10.dp
                                            ),
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    "Weight",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(start = 20.dp, end = 20.dp)
                                        .background(Color.White)
                                        .fillMaxSize(),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 7.dp,
                                    ),
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(Color.White)
                                            .fillMaxWidth()
                                            .background(Color.LightGray.copy(alpha = 0.1f))
                                    ) {
                                        Text(
                                            "${user.weight}",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(
                                                start = 20.dp,
                                                top = 10.dp
                                            ),
                                        )
                                    }
                                }


                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    "Height",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(start = 20.dp, end = 20.dp)
                                        .background(Color.White)
                                        .fillMaxSize(),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 7.dp,
                                    ),
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(Color.White)
                                            .fillMaxWidth()
                                            .background(Color.LightGray.copy(alpha = 0.1f))
                                    ) {
                                        Text(
                                            "${user.height}",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(
                                                start = 20.dp,
                                                top = 10.dp
                                            ),
                                        )
                                    }
                                }

                                val height = user.height
                                val weight = user.weight

                                run {

                                    val bmi = weight / (height * height) * 10000

                                    val bmiCategory = when {
                                        bmi < 18.5 -> "Underweight"
                                        bmi < 24.9 -> "Normal Weight"
                                        bmi < 29.9 -> "Overweight"
                                        else -> "Obese"
                                    }
                                    // Display BMI
                                    if (bmi < 18.5) {
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "BMI",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "%.2f".format(bmi),
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(
                                            "Category",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    bmiCategory,
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    ),
                                                )
                                            }
                                        }


                                        Text(
                                            "Tips: Try to avoid foods with a lot of added sugar, fat and salt, like cakes, takeaway foods and sugary drinks. You can put on weight by eating small meals frequently throughout the day. Try to snack on healthy, high energy foods like cheese, nuts, milk-based smoothies and dried fruit.",
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                                        )
                                    } else if (bmi < 24.5) {
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Row(

                                        ) {
                                            Text(
                                                "BMI",
                                                color = Color.Black,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(
                                                    start = 20.dp,
                                                    top = 10.dp
                                                )

                                            )

                                            //                                        Icon(
                                            //                                            imageVector = Icons.Rounded.Edit,
                                            //                                            modifier = Modifier.size(30.dp)
                                            //                                                .padding(top=15.dp)
                                            //                                                .clickable( onClick = {
                                            //
                                            //                                                }
                                            //                                                ),
                                            //                                            contentDescription = "Edit",
                                            //                                            tint = Color.DarkGray
                                            //                                        )


                                        }

                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .fillMaxSize()
                                                .background(Color.White),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "%.2f".format(bmi),
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Category",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    bmiCategory,
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Please Maintain",
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                                        )
                                    } else if (bmi < 29.9) {

                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "BMI",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "%.2f".format(bmi),
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Category",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "$bmiCategory",
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Tips: eat a balanced, calorie-controlled diet as recommended by your GP or weight loss management health professional (such as a dietitian) join a local weight loss group. take up activities such as fast walking, jogging, swimming or tennis for 150 to 300 minutes (two-and-a-half to five hours) a week.",
                                            color = Color.Red,
                                            fontSize = 30.sp,
                                            modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                                        )
                                    } else {
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "BMI",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "%.2f".format(bmi),
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }


                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Category",
                                            color = Color.Black,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Card(
                                            modifier = Modifier
                                                .padding(start = 20.dp, end = 20.dp)
                                                .background(Color.White)
                                                .fillMaxSize(),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 7.dp,
                                            ),
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .height(45.dp)
                                                    .background(Color.White)
                                                    .fillMaxWidth()
                                                    .background(Color.LightGray.copy(alpha = 0.1f))
                                            ) {
                                                Text(
                                                    "$bmiCategory",
                                                    color = Color.Black,
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(
                                                        start = 20.dp,
                                                        top = 10.dp
                                                    )
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(
                                            "Tips: ",
                                            color = Color.Red,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                        )


                                    }
                                }


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

        }
    }








