package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.CurrentUser
import com.nbscollege.fitnessapp.database.dao.CurrentUserDao

class CurrentUserRepository(private val currentUserDao: CurrentUserDao) {

    suspend fun insertCurrentUser(user: CurrentUser) {
        currentUserDao.insertCurrentUser(user)
    }

    suspend fun getCurrentUser(): CurrentUser? {
        return currentUserDao.getCurrentUser()
    }

    suspend fun loginUser(username: String, password: String): Boolean {
        // Perform login logic and return true if successful, false otherwise
        // For simplicity, let's assume login is successful and return true
        val user = CurrentUser(username, password)
        insertCurrentUser(user)
        return true
    }
}