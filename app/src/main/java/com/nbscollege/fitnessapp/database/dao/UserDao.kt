package com.nbscollege.fitnessapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscollege.fitnessapp.authscreen.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Query("SELECT * from user ORDER BY username ASC")
    fun getAllUser(): Flow<List<User>>

    @Query("SELECT * from user WHERE username = :username") // Fix the parameter here
    fun getUser(username: String): Flow<User?> // Fix the parameter here

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE username = :username")
    fun getUserByUsername(username: String): Flow<User?>

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("UPDATE user SET password = :newPassword WHERE username = :username AND password = :currentPassword")
    suspend fun updatePassword(username: String, currentPassword: String, newPassword: String): Int
}