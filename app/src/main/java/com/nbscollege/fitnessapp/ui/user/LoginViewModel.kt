package com.nbscollege.fitnessapp.ui.user



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscollege.fitnessapp.authscreen.model.LoggedInUserHolder
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    // State for UI to observe
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginState: StateFlow<LoginState> = _loginState





    // Property to store the current logged-in user
    private var _currentUser: User? = null
    val currentUser: User? get() = _currentUser

    var status by mutableStateOf(false)
    var username by mutableStateOf("")
    var password by mutableStateOf("")



    // Function to perform login
    fun login(username: String, password: String) {
        viewModelScope.launch {
            // Perform authentication logic here
            val user = userRepository.getUserStream(username).firstOrNull()

            if (user != null && user.password == password) {
                _loginState.value = LoginState.Success(user)
                val loggedInUser = User(
                    id = user.id,
                    username = user.username,
                    password = user.password,
                    weight = user.weight,
                    height = user.height,
                    age = user.age
                )
                LoggedInUserHolder.setLoggedInUser(loggedInUser)


                _currentUser = user
                _loginState.value = LoginState.Success(user)





                // Save user session in SharedPreferences

            } else {
                _loginState.value = LoginState.Error("Invalid credentials")
            }
        }
    }




}



sealed class LoginState {
    data object Initial : LoginState()
    data class Success(val user: User) : LoginState()

    data class Error(val error: String) : LoginState()
}