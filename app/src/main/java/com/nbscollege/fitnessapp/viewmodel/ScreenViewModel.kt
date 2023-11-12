package com.nbscollege.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ScreenViewModel : ViewModel() {
    private val _splashLoaded = MutableStateFlow(false)
    private val _isLoggedin = MutableStateFlow(false)
    val splashLoaded = _splashLoaded.asStateFlow()
    val isLoggedin = _isLoggedin.asStateFlow()

    fun runSplashScreen() {
        viewModelScope.launch {
            // show splash screen for 2 seconds
            delay(1500)
            _splashLoaded.value = true
        }
    }

    fun loginUser() {
        viewModelScope.launch {
            // set status to loggedIn after 2 seconds
            delay(2000)
            _isLoggedin.value = true
        }
    }
}