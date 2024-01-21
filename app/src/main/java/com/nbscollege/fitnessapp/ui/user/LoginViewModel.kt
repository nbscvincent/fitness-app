package com.nbscollege.fitnessapp.ui.user



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.nbscollege.fitnessapp.authscreen.model.LoggedInUserHolder
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.repository.UserRepository
import com.nbscollege.fitnessapp.navigation.SettingsRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    // State for UI to observe
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginState: StateFlow<LoginState> = _loginState

    var status by mutableStateOf(false)
    var username by mutableStateOf("")
    var password by mutableStateOf("")



    var oldPasswordCorrect by mutableStateOf(true)

    fun changePassword(oldPassword: String, newPassword: String, navController: NavController) {
        viewModelScope.launch {
            val loggedInUser = LoggedInUserHolder.getLoggedInUser()

            if (loggedInUser != null && loggedInUser.password == oldPassword) {
                // Old password is correct, perform password change logic
                userRepository.changePassword(loggedInUser.username, newPassword)
                oldPasswordCorrect = true
                // Optionally, you can update the state or perform any other action

                navController.navigate(SettingsRoute.LogOut.name)

            } else {

                oldPasswordCorrect = false
            }
        }
    }


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
                    age = user.age,

                )
                LoggedInUserHolder.setLoggedInUser(loggedInUser)

                _loginState.value = LoginState.Success(user)



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