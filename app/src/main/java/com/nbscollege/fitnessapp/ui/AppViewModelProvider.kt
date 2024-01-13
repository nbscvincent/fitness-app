package com.nbscollege.fitnessapp.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nbscollege.fitnessapp.FitnessApp
import com.nbscollege.fitnessapp.ui.user.LoginViewModel
import com.nbscollege.fitnessapp.ui.user.ProfileViewModel
import com.nbscollege.fitnessapp.ui.user.RegistrationViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {
        // Initializer for RegistrationViewModel
        initializer {
            RegistrationViewModel(FitnessApp().container.userRepository)
        }
        // Initializer for RegistrationViewModel
        initializer {
            RegistrationViewModel(FitnessApp().container.userRepository)
        }

        initializer {
            LoginViewModel(FitnessApp().container.userRepository)

        }
        initializer {
            LoginViewModel(FitnessApp().container.userRepository)

        }
        initializer {
            ProfileViewModel(FitnessApp().container.userRepository)
        }







    }
}
/**
 * Extension function to queries for [FitnessApp] object and returns an instance of
 * [FitnessApp].
 */
fun CreationExtras.FitnessApp(): FitnessApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FitnessApp)