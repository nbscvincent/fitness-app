package com.nbscollege.fitnessapp.data

import android.content.Context
import com.nbscollege.fitnessapp.data.user.repository.OfflineUserRepository
import com.nbscollege.fitnessapp.data.user.repository.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [userRepository]
     */
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(FitnessDatabase.getDatabase(context).userDao())
    }
}