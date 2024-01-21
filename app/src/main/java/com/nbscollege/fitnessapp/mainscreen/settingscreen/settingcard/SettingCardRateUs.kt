package com.nbscollege.fitnessapp.mainscreen.settingscreen.settingcard

//@Composable
//fun SettingCardRateUs(
//    general: General,
//    context: Context,
//    navController: NavController,
//    isDialogVisible: Boolean,
//    onDialogDismiss: (Boolean) -> Unit
//) {
//
//    Spacer(modifier = Modifier.height(5.dp))
//    Card(
//        modifier = Modifier
////            .fillMaxSize()
//            .padding(start = 20.dp, end = 20.dp)
//            .background(Color.White),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 4.dp,
//        ),
//        content = {
//            Box(
//                modifier = Modifier.fillMaxSize()
//
//            ) {
//
//                Row(
//                    modifier = Modifier
//                        .height(60.dp)
//                        .background(Color.White)
//                        .fillMaxWidth()
//                        .background(Color.LightGray.copy(alpha = 0.1f))
//                        .clickable(onClick = {
//                            if (!isDialogVisible) {
//                                onDialogDismiss(true)
//                            }
//                        }),
//                ) {
//                    Icon(
//                        imageVector = Icons.Outlined.StarOutline, // You can use any other icon
//                        contentDescription = null,
//                        tint = Color.Red,
//                        modifier = Modifier.padding(start = 20.dp, top = 17.dp)
//                    )
//                    Text(
//                        general.title,
//                        color = Color.Black,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.padding(start=10.dp, top=17.dp)
//                    )
//                    Spacer(modifier = Modifier.weight(1f))
//                }
//
//            }
//        },
//    )
//
//    Spacer(modifier = Modifier
//        .height(8.dp)
//        .background(Color.White))
//
//    if (isDialogVisible) {
//        RateUsDialog(onDismiss = { onDialogDismiss(false) }) {
//            // Handle the logic for sending feedback
//            onDialogDismiss(false)
//            navController.navigate(Screen.SettingScreen.name)
//        }
//    }
//}