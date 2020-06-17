package com.rebrain.konstload.foodapp.base

import android.app.Application
import com.rebrain.konstload.foodapp.di.ContextModule
import com.rebrain.konstload.foodapp.di.components.AppComponent
import com.rebrain.konstload.foodapp.di.components.DaggerAppComponent
import com.rebrain.konstload.foodapp.di.components.DaggerScreenComponent
import com.rebrain.konstload.foodapp.di.components.ScreenComponent
import timber.log.Timber

/**
 * Базовый класс приложения.
 **/
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    fun buildScreenComponent():ScreenComponent {
        return DaggerScreenComponent.builder()
            .appComponent(appComponent)
            .build()
    }
}