package com.nbscollege.fitnessapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nbscollege.fitnessapp.authscreen.model.User

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class FitnessDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao


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