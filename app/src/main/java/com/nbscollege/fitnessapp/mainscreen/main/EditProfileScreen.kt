package com.nbscollege.fitnessapp.mainscreen.main

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditProfileScreen(
    screenViewModel: ScreenViewModel,
    navController: NavController,
) {
    // You can use the same logic as your profile screen to get the user's current information
    val profile = screenViewModel.currentUser.value

    // Local state to hold the edited values
    var editedHeight by remember { mutableStateOf(profile?.height.toString()) }
    var editedWeight by remember { mutableStateOf(profile?.weight.toString()) }

    Scaffold(
        topBar = {
            // Top bar with a title and save button
            TopAppBar(
                title = { Text("Edit Profile") },
                navigationIcon = {
                    // Back button to navigate back
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    // Save button to save the edits
                    IconButton(onClick = {
                        // Update the user's profile with the edited values
                        screenViewModel.updateProfile(
                            editedHeight.toFloatOrNull(),
                            editedWeight.toFloatOrNull()
                        )
                        // Navigate back to the profile screen
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Rounded.Check, contentDescription = "Save")
                    }
                }
            )
        },
        content = {
            // Editable fields for height and weight
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                // Edit text for height
                OutlinedTextField(
                    value = editedHeight,
                    onValueChange = { editedHeight = it },
                    label = { Text("Height") },
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // Edit text for weight
                OutlinedTextField(
                    value = editedWeight,
                    onValueChange = { editedWeight = it },
                    label = { Text("Weight") },
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )
}