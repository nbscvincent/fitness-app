package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    /**
     * Retrieve all the users from the the given data source.
     */
    fun getAllUsersStream(): Flow<List<User>>

    /**
     * Retrieve an user from the given data source that matches with the [id].
     */
    fun getUserStream(id: Int): Flow<User?>

    /**
     * Retrieve an user from the given data source that matches with the [username].
     */

    suspend fun getUserByUsername(username: String): User?

    /**
     * Retrieve a user from the given data source that matches with the [email].
     */

    /**
     * Retrieve a user from the given data source that matches with the [userId].
     */
    suspend fun getUserById(userId: Int): User?


    /**
     * Insert user in the data source
     */
    suspend fun insertUser(user: User)

    /**
     * Delete user from the data source
     */
    suspend fun deleteUser(user: User)

    /**
     * Update user in the data source
     */
    suspend fun updateUser(user: User)
}

