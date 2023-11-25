package com.nbscollege.fitnessapp.database

import android.content.Context
import com.nbscollege.fitnessapp.database.repository.OfflineUserRepository
import com.nbscollege.fitnessapp.database.repository.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [userRepository]
     */
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(FitnessDataBase.getDatabase(context).userDao())
    }

//    override val testimonialRepository: TestimonialRepository by lazy {
//        OfflineTestimonialRepository(NBSDatabase.getDatabase(context).testimonialDao())
//    }
}