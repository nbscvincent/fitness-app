package com.nbscollege.fitnessapp.ui.user

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nbscollege.fitnessapp.authscreen.model.User

class ProfileViewModel : ViewModel() {
    var currentUser = mutableStateOf(User(0, "", "", 0.0f, 0.0f,0))
}
