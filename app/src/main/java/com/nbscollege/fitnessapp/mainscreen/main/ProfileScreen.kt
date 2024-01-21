package com.nbscollege.fitnessapp.model


import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.authscreen.model.LoggedInUserHolder
import com.nbscollege.fitnessapp.mainscreen.main.SplashLoading
import com.nbscollege.fitnessapp.ui.AppViewModelProvider
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition",
    "StateFlowValueCalledInComposition"
)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
fun ProfileScreen(
    screenViewModel: ScreenViewModel,
    navController: NavController,

    loginViewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)

) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val categoryColors = mapOf(
        "Underweight" to Color(0xFF42A5F5),
        "Normal Weight" to Color(0xFF4CAF50),
        "Overweight" to Color(0xFFF57C00),
        "Obese" to Color(0xFFD32F2F)
    )


    val density = LocalDensity.current.density


    val loggedInUser = LoggedInUserHolder.getLoggedInUser() ?: run {
        val preferences = context.getSharedPreferences("prefs", 0)
        if (preferences.getBoolean("status", false)) {
            val username = preferences.getString("username", "") ?: ""
            val password = preferences.getString("password", "") ?: ""
            loginViewModel.login(username, password)
            LoggedInUserHolder.getLoggedInUser()
        } else {
            null
        }
    }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .padding()
                    .background(Color(0xFFE57373))
                    .height(200.dp)
                    .fillMaxWidth(),

            ) {
                Column(
                    verticalArrangement = Arrangement.Center, // Center vertically
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .background(Color(0xFFE57373))
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            modifier = Modifier.size(38.dp),
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "Profile",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(),
                        )
                        Spacer(modifier = Modifier.width(5.dp))


                    }



                    loggedInUser?.let { user ->

                        Spacer(modifier = Modifier.height(20.dp))


                        Text(
                            "Hello, ${user.username}",
                            color = Color.Black,
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(),
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .background(Color(0xFFE57373))
                                .graphicsLayer(translationY = 40f, translationX = 0f)
                                .fillMaxSize(),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp,
                            ),
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(150.dp)
                                    .background(Color.White)
                                    .fillMaxWidth()
                                    .background(Color.LightGray.copy(alpha = 0.1f))
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "${user.age}\nAge",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .padding()
                                            .weight(1f),
                                    )
                                    Box(
                                        modifier = Modifier
                                            .background(Color.Gray)
                                            .width(1.dp)
                                            .fillMaxHeight()
                                    )
                                    Text(
                                        "${user.weight.toInt()}kg\nWeight",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .padding()
                                            .weight(1f),
                                    )
                                    Box(
                                        modifier = Modifier
                                            .background(Color.Gray)
                                            .width(1.dp)
                                            .fillMaxHeight()
                                    )
                                    Text(
                                        "${user.height.toInt()}cm\nHeight",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .padding()
                                            .weight(1f),
                                    )

                                }
                            }

                        }




                    }

                }


            }
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    ) { innerPadding ->


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(innerPadding)
                            .clip(RoundedCornerShape(32.dp))
                    ) {

                        item {
                            loggedInUser?.let { user ->


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
                                    if (bmi < 18.5 ) {
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
                                            "Tis: Focus on a balanced and nutritious diet to ensure you are getting enough calories and essential nutrients.\n" +
                                                    "Include protein-rich foods, healthy fats, and complex carbohydrates in your meals.\n" +
                                                    "Consider consulting with a healthcare professional or a nutritionist to develop a healthy weight gain plan",
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
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

                                        Spacer(modifier = Modifier.height(16.dp))
                                        BmiGraphic(bmi = bmi, category = bmiCategory)
//                                        BmiBarChart(bmi = bmi, category = bmiCategory)


                                        Text(
                                            "Tips: Maintain a balanced diet that includes a variety of fruits, vegetables, lean proteins, whole grains, and healthy fats." +
                                                    "Engage in regular physical activity to support overall health and well-being." +
                                                    "Monitor your weight to ensure it stays within the normal BMI range.",
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
                                        )
                                        Spacer(modifier = Modifier.height(20.dp))
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
                                            "Tips: Adopt a well-balanced and portion-controlled diet to manage calorie intake.\n" +
                                                    "Increase physical activity levels with a mix of cardiovascular exercise and strength training.\n" +
                                                    "Consult with a healthcare professional or a registered dietitian for personalized advice and guidance.",
                                            color = Color.Red,
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
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
                                            "Tips: Seek professional guidance for a comprehensive weight management plan that includes dietary changes and increased physical activity.\n" +
                                                    "Consider working with a healthcare provider, nutritionist, or weight loss specialist to develop a sustainable and effective approach.\n" +
                                                    "Focus on gradual, sustainable changes rather than extreme or fad diets.",
                                            color = Color.Red,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(start = 30.dp, top = 10.dp)
                                        )


                                    }
                                }


                                } ?: run {

                                SplashLoading(navController)
//                                Text(
//                                    text = "Please Wait",
//                                    style = TextStyle(fontSize = 20.sp),
//                                    color = Color.Red
//                                )


                            }
                        }




                    }





        }
    }

@Composable
fun BmiGraphic(bmi: Float, category: String) {
    // Define colors for each BMI category
    val underweightColor = Color.Blue
    val normalWeightColor = Color.Green
    val overweightColor = Color.Yellow
    val obeseColor = Color.Red

    // Define labels for each BMI category
    val underweightLabel = "Underweight"
    val normalWeightLabel = "Normal Weight"
    val overweightLabel = "Overweight"
    val obeseLabel = "Obese"

    // Draw the entire BMI bar graph
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // Increased height to accommodate labels
    ) {
        // Calculate individual bar widths for each category
        val underweightBarWidth = size.width * (18.5f / 60f)
        val normalWeightBarWidth = size.width * (24.9f / 40f - 18.5f / 50f)
        val overweightBarWidth = size.width * (29.9f / 40f - 24.9f / 48f)
        val obeseBarWidth = size.width * (1f - 29.9f / 40f)

        // Draw bars for each category
        drawRoundRect(
            color = underweightColor,
            size = Size(underweightBarWidth, size.height),
            cornerRadius = CornerRadius.Zero
        )
        drawRoundRect(
            color = normalWeightColor,
            size = Size(normalWeightBarWidth, size.height),
            topLeft = Offset(underweightBarWidth, 0f),
            cornerRadius = CornerRadius.Zero
        )
        drawRoundRect(
            color = overweightColor,
            size = Size(overweightBarWidth, size.height),
            topLeft = Offset(underweightBarWidth + normalWeightBarWidth, 0f),
            cornerRadius = CornerRadius.Zero
        )
        drawRoundRect(
            color = obeseColor,
            size = Size(obeseBarWidth, size.height),
            topLeft = Offset(underweightBarWidth + normalWeightBarWidth + overweightBarWidth, 0f),
            cornerRadius = CornerRadius.Zero
        )

        // Draw labels for each category
        drawIntoCanvas {
            val paint = Paint().apply {

                textSize = 15.sp.toPx() // Set the text size to 20sp
            }

            it.nativeCanvas.drawText(
                underweightLabel,
                underweightBarWidth / 1 - 100.dp.toPx(),
                size.height + -20.dp.toPx(),
                paint
            )
            it.nativeCanvas.drawText(
                normalWeightLabel,
                underweightBarWidth + normalWeightBarWidth / 2 - 45.dp.toPx(),
                size.height + -20.dp.toPx(),
                paint
            )
            it.nativeCanvas.drawText(
                overweightLabel,
                underweightBarWidth + normalWeightBarWidth + overweightBarWidth / 2 - 30.dp.toPx(),
                size.height + -20.dp.toPx(),
                paint
            )
            it.nativeCanvas.drawText(
                obeseLabel,
                underweightBarWidth + normalWeightBarWidth + overweightBarWidth + obeseBarWidth / 1 - 80.dp.toPx(),
                size.height + -20.dp.toPx(),
                paint
            )
        }
    }
}

@Composable
fun BmiBarChart(bmi: Float, category: String) {
    // Define colors for each BMI category
    val underweightColor = Color.Blue
    val normalWeightColor = Color.Green
    val overweightColor = Color.Yellow
    val obeseColor = Color.Red

    // Define labels for each BMI category
    val underweightLabel = "Underweight"
    val normalWeightLabel = "Normal Weight"
    val overweightLabel = "Overweight"
    val obeseLabel = "Obese"

    // Map BMI categories to colors and labels
    val bmiCategories = listOf(
        underweightColor to underweightLabel,
        normalWeightColor to normalWeightLabel,
        overweightColor to overweightLabel,
        obeseColor to obeseLabel
    )

    // Draw the BMI bar chart with labels
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust the height as needed
    ) {
        val totalWidth = size.width
        val barWidth = totalWidth / bmiCategories.size

        bmiCategories.forEachIndexed { index, (color, label) ->
            val startX = index * barWidth
            drawRect(
                color = color,
                topLeft = Offset(startX, 0f),
                size = Size(barWidth, size.height)
            )

            drawIntoCanvas {
                val paint = Paint().apply {

                    textSize = 16.sp.toPx() // Adjust the text size as needed
                }
                it.nativeCanvas.drawText(
                    label,
                    startX + barWidth / 2 - (label.length * 8), // Adjust text alignment
                    size.height + 20.dp.toPx(),
                    paint
                )
            }
        }
    }
}




@Composable
fun calculateBmi(height: Int, weight: Int): Float {
    val heightInMeters = height / 100f
    return weight / (heightInMeters * heightInMeters)
}








