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
    @Query("SELECT * from User ORDER BY userId ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * from User WHERE userId = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT * FROM User WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?



    // Specify the conflict strategy as REPLACE, when the user tries to add an
    // existing User into the database Room REPLACES the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)


}