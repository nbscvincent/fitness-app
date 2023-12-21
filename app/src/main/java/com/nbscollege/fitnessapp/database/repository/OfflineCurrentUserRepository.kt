package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.CurrentUser
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.dao.CurrentUserDao

class CurrentUserOfflineRepository(
    private val currentUserDao: CurrentUserDao,
    private val userRepository: UserRepository
) : CurrentUserRepository {
    override suspend fun getCurrentUser(): CurrentUser? = currentUserDao.getCurrentUser()

    override suspend fun insertCurrentUser(currentUser: User) {
        val currentUserEntity = CurrentUser(
            userId = currentUser.userId,
            username = currentUser.username,
            password = currentUser.password,
            height = currentUser.height,
            weight = currentUser.weight,
            age = currentUser.age,
        )
        currentUserDao.insertCurrentUser(currentUserEntity)
    }

    override suspend fun clearCurrentUser() {
        currentUserDao.clearCurrentUser()
    }

    override suspend fun getCurrentUserId(): Int? {
        val currentUser = currentUserDao.getCurrentUser()
        return currentUser?.userId
    }
}