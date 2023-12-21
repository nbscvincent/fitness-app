package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.CurrentUser
import com.nbscollege.fitnessapp.authscreen.model.User


interface CurrentUserRepository {
    suspend fun getCurrentUser(): CurrentUser?
    suspend fun insertCurrentUser(currentUser: User)
    suspend fun clearCurrentUser()
    suspend fun getCurrentUserId(): Int?
}