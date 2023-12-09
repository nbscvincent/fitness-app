package com.nbscollege.fitnessapp.database.dao

import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscollege.fitnessapp.authscreen.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {
    @Query("SELECT * from category ORDER BY title ASC")
    fun getAllCategory(): Flow<List<Category>>
    @Query("SELECT * from category WHERE title = title")
    fun getCategory(): Flow<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)
    @Update
    suspend fun update(category: Category)
    @Delete
    suspend fun delete(category: Category)
}