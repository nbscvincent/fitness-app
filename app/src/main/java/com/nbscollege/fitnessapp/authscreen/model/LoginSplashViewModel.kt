package com.nbscollege.fitnessapp.authscreen.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginSplashViewModel : ViewModel() {
    private val _splashShown = MutableStateFlow(false)
    val splashShown = _splashShown.asStateFlow()

    fun showSplashScreen() {
        viewModelScope.launch {
            // show splash screen for 2 seconds
            delay(2000)
            _splashShown.value = true
        }
    }
}