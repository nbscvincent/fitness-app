package com.nbscollege.fitnessapp.database

import android.content.Context
import com.nbscollege.fitnessapp.database.repository.CategoryRepository
import com.nbscollege.fitnessapp.database.repository.CurrentUserOfflineRepository
import com.nbscollege.fitnessapp.database.repository.CurrentUserRepository
import com.nbscollege.fitnessapp.database.repository.OfflineCategoryRepository
import com.nbscollege.fitnessapp.database.repository.OfflineUserRepository
import com.nbscollege.fitnessapp.database.repository.UserRepository

interface AppContainer {
    val userRepository: UserRepository
    val categoryRepository: CategoryRepository
    val currentUserRepository: CurrentUserRepository

}
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [userRepository]
     */
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(FitnessDataBase.getDatabase(context).userDao())
    }

    override val categoryRepository: CategoryRepository by lazy {
        OfflineCategoryRepository(FitnessDataBase.getDatabase(context).categoryDao())
    }

    override val currentUserRepository: CurrentUserRepository by lazy {
        CurrentUserOfflineRepository(
            FitnessDataBase.getDatabase(context).currentUserDao(),
            userRepository
        )
    }








//    override val testimonialRepository: TestimonialRepository by lazy {
//        OfflineTestimonialRepository(NBSDatabase.getDatabase(context).testimonialDao())
//    }

}