package com.nbscollege.fitnessapp.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userDetails = MutableStateFlow<User?>(null)
    val userDetails: StateFlow<User?> = _userDetails

    fun loadUserDetails(username: String) {
        viewModelScope.launch {
            val user = userRepository.getUserStream(username).firstOrNull()
            _userDetails.value = user
        }
    }


}