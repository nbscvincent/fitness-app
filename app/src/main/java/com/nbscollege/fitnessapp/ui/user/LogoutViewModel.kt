package com.nbscollege.fitnessapp.ui.user

import androidx.lifecycle.ViewModel
import com.nbscollege.fitnessapp.authscreen.model.LoggedInUserHolder
import com.nbscollege.fitnessapp.database.repository.UserRepository

class SettingsViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    fun logout() {
        // Clear the logged-in user data
        LoggedInUserHolder.clearLoggedInUser()
    }



}