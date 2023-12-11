package com.nbscollege.fitnessapp.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nbscollege.fitnessapp.database.dao.UserDao
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.dao.CategoryDao
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [User::class, Category::class], version = 1, exportSchema = true)
abstract class FitnessDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao


    companion object {
        @Volatile
        private var Instance: FitnessDataBase? = null
        fun getDatabase(context: Context): FitnessDataBase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FitnessDataBase::class.java, "fitness_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }

    }


}