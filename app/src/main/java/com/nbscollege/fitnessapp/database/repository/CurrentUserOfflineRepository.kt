package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.CurrentUser
import com.nbscollege.fitnessapp.database.dao.CurrentUserDao

class CurrentUserOfflineRepository(private val currentUserDao: CurrentUserDao) {

    suspend fun insertCurrentUser(user: CurrentUser) {
        currentUserDao.insertCurrentUser(user)
    }

    suspend fun getCurrentUser(): CurrentUser? {
        return currentUserDao.getCurrentUser()
    }
}