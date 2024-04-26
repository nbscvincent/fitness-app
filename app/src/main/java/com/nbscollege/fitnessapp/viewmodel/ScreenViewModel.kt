package com.nbscollege.fitnessapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.authscreen.model.registeredUsers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ScreenViewModel() : ViewModel() {
    private val _splashLoaded = MutableStateFlow(false)
    private val _isLoggedin = MutableStateFlow(false)
    val splashLoaded = _splashLoaded.asStateFlow()
//    var isLoggedin = _isLoggedin.asStateFlow()
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser = _currentUser.asStateFlow()

    private val _isLoggedOut = MutableStateFlow(false)
    val isLoggedOut = _isLoggedOut.asStateFlow()

    private val _isProgressVisible = MutableStateFlow(false)
    val isProgressVisible: StateFlow<Boolean> = _isProgressVisible.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()
    private val _uiState = MutableStateFlow(ScreenUiState())

    private val _isLogin = MutableStateFlow(false)
    val isLogin = _isLogin.asStateFlow()

    fun setLogin(){
        _isLogin.value = true;
    }
    fun resetLogoutUser() {
        _isLoggedOut.value = false
    }
    fun logoutUser() {
        viewModelScope.launch {
            delay(2000)
            _isLoggedOut.value = true
        }
    }


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

//    private val _loggedInUsername = mutableStateOf<String?>(null)
//    val loggedInUsername: State<String?> = _loggedInUsername
//
//    fun setLoggedInUser(username: String) {
//        _loggedInUsername.value = username
//    }







}

data class ScreenUiState(
    /** Name of selectedScreen screen */

    /** Name of selected screen */
    val selectedScreen: String = "",
)
