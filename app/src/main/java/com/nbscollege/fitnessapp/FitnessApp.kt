package com.nbscollege.fitnessapp

import android.app.Application
import com.nbscollege.fitnessapp.database.AppContainer
import com.nbscollege.fitnessapp.database.AppDataContainer
import com.nbscollege.fitnessapp.ui.user.SharedPreferencesManager


class FitnessApp: Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        sharedPreferencesManager = SharedPreferencesManager(applicationContext)
    }
}