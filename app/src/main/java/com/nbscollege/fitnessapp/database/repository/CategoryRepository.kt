package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    /**
     * Retrieve all the users from the the given data source.
     */
    fun getAllCategoryStream(): Flow<List<Category>>

    /**
     * Retrieve an user from the given data source that matches with the [id].
     */
    fun getCategoryStream(id: Int): Flow<Category?>

    /**
     * Insert user in the data source
     */
    suspend fun insertCategory(category: Category)

    /**
     * Delete user from the data source
     */
    suspend fun deleteCategory(category: Category)

    /**
     * Update user in the data source
     */
    suspend fun updateCategory(category: Category)
}

