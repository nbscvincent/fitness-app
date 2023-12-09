package com.nbscollege.fitnessapp.database.repository

import com.nbscollege.fitnessapp.database.dao.CategoryDao

import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.dao.UserDao
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category
import kotlinx.coroutines.flow.Flow

class OfflineCategoryRepository(private val categoryDao: CategoryDao) : CategoryRepository {
    override fun getAllCategoryStream(): Flow<List<Category>> = categoryDao.getAllCategory()

    override fun getCategoryStream(id: Int): Flow<Category?> = categoryDao.getCategory()

    override suspend fun insertCategory(category: Category) = categoryDao.insert(category)
    override suspend fun deleteCategory(category: Category) = categoryDao.delete(category)

    override suspend fun updateCategory(category: Category) = categoryDao.update(category)
}