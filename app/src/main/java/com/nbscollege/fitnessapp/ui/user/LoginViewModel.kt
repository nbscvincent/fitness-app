package com.nbscollege.fitnessapp.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nbscollege.fitnessapp.database.repository.CurrentUserRepository
import com.nbscollege.fitnessapp.database.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: CurrentUserRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean>
        get() = _loginResult

    fun loginUser(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = userRepository.loginUser(username, password)
            _loginResult.postValue(result)
        }
    }
}