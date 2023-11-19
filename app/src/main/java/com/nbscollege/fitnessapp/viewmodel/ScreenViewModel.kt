package com.nbscollege.fitnessapp.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.model.LoginScreen
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
import com.nbscollege.fitnessapp.model.homescreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ScreenViewModel : ViewModel() {
    private val _splashLoaded = MutableStateFlow(false)
    private val _isLoggedin = MutableStateFlow(false)
    val splashLoaded = _splashLoaded.asStateFlow()
//    var isLoggedin = _isLoggedin.asStateFlow()
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser = _currentUser.asStateFlow()

    fun runSplashScreen() {
        viewModelScope.launch {
            // show splash screen for 2 seconds
            delay(1500)
            _splashLoaded.value = true
        }
    }

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            // set status to loggedIn after 2 seconds
            val user = registeredUsers.find { it.username == username && it.password == password }
            _isLoggedin.value = true
            _currentUser.value = user
        }
    }




}

