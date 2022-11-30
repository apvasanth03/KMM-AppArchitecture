package com.vasanth.kmm.apparchitecture.android.application

import android.app.Application
import com.vasanth.kmm.apparchitecture.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KMMApplication : Application() {

    // Application Methods
    override fun onCreate() {
        super.onCreate()

        initializeDIContainer()
    }

    // Private Methods
    private fun initializeDIContainer() {
        startKoin {
            androidLogger()
            androidContext(this@KMMApplication)
            modules(sharedModule())
        }
    }
}