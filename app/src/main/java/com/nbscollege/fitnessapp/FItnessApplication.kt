package com.nbscollege.fitnessapp

import android.app.Application
import com.nbscollege.fitnessapp.data.AppContainer
import com.nbscollege.fitnessapp.data.AppDataContainer

class FItnessApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
