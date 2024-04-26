package com.nbscollege.fitnessapp.ui.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.repository.UserRepository
import com.nbscollege.fitnessapp.database.repository.onlineRepository.OnlineUserRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class RegistrationViewModel(private val userRepository: UserRepository, private val onlineUserRepository: OnlineUserRepository) : ViewModel() {

    /**
     * Holds current user ui state
     */
    var userUiState by mutableStateOf(UserUiState())
        private set
    /**
     * Updates the [userUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }
    /**
     * Inserts an [User] in the Room database
     */
    suspend fun saveUser() {
        if (validateInput()) {
            userRepository.insertUser(userUiState.userDetails.toUser()) ; onlineUserRepository.insertUser(userUiState.userDetails.toUser())

        }
    }
    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            username.isNotBlank() && password.isNotBlank()
        }
    }

    suspend fun selectUser(username:String, password: String) : Flow<User?>? {

        var flow : Flow<User?>? = null

        //flow = usersRepository.getUserPasswordStream(userDetails.username, userDetails.password)
        try {
            flow = userRepository.getUserStream(username,password); onlineUserRepository.getUserStream(username,password)

        } catch (e: Exception){
            Timber.i("SAMPLE $e")
        }
        return flow
    }
}

/**
 * Represents Ui State for an User.
 */
data class UserUiState(
    var userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)
data class UserDetails(
    val username: String = "",
    val password: String = "",
    val id: Int = 0,
    val weight: Float = 0.00f,
    val height: Float = 0.00f,
    val age: Int = 0
)
/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun UserDetails.toUser(): User = User(
    id = id,
    username = username,
    password = password,
    weight = weight,
    height = height,
    age = age,
)
/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun User.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)
/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun User.toUserDetails(): UserDetails = UserDetails(
    id = id,
    username = username,
    password = password,
    weight = weight,
    height = height,
    age = age,
)
