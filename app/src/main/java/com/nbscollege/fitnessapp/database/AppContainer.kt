package com.nbscollege.fitnessapp.database

import android.content.Context
import com.nbscollege.fitnessapp.database.repository.CategoryRepository
import com.nbscollege.fitnessapp.database.repository.UserRepository
import com.nbscollege.fitnessapp.database.repository.offlineRepository.OfflineCategoryRepository
import com.nbscollege.fitnessapp.database.repository.offlineRepository.OfflineUserRepository
import com.nbscollege.fitnessapp.database.repository.onlineRepository.OnlineUserRepository


interface AppContainer {
    val userRepository: UserRepository
    val categoryRepository: CategoryRepository
    val onlineUserRepository: OnlineUserRepository



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

    override val onlineUserRepository: OnlineUserRepository by lazy {
        OnlineUserRepository()
    }












//    override val testimonialRepository: TestimonialRepository by lazy {
//        OfflineTestimonialRepository(NBSDatabase.getDatabase(context).testimonialDao())
//    }

}