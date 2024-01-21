package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.dao.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class OfflineUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getAllUsersStream(): Flow<List<User>> = userDao.getAllUser()

    override fun getUserStream(username: String): Flow<User?> = userDao.getUser(username)

    override suspend fun insertUser(user: User) = userDao.insert(user)

    override suspend fun deleteUser(user: User) = userDao.delete(user)

    override suspend fun updateUser(user: User) = userDao.update(user)



    override suspend fun changePassword(username: String, newPassword: String) {
        // Fetch the user by username
        val user = userDao.getUser(username).firstOrNull()

        // Update the password if the user exists
        user?.let {
            userDao.update(it.copy(password = newPassword))
        }
    }

}