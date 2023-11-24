package com.nbscollege.fitnessapp.mainscreen.main

import android.util.Half.toFloat
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.viewmodel.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(user: User, onUserUpdated: (User) -> Unit) {
    var updatedUser by remember { mutableStateOf(user.copy()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display non-editable details
        Text("Username: ${user.username}")
        Text("Weight: ${user.weight ?: "N/A"}")
        Text("Height: ${user.height ?: "N/A"}")
        Text("Age: ${user.age}")

        // Editable fields
        OutlinedTextField(
            value = updatedUser.password,
            onValueChange = { updatedUser = updatedUser.copy(password = it) },
            label = { Text("New Password") }
        )
        OutlinedTextField(
            value = updatedUser.confirmPassword,
            onValueChange = { updatedUser = updatedUser.copy(confirmPassword = it) },
            label = { Text("Confirm New Password") }
        )

        // Add more OutlinedTextField components for other editable fields (weight, height, age)

        Spacer(modifier = Modifier.height(16.dp))

        // Save button
        Button(onClick = { onUserUpdated(updatedUser) }) {
            Text("Save Changes")
        }
    }
}