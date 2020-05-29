package com.rebrain.konstload.foodapp.base

import android.app.Application
import com.rebrain.konstload.foodapp.di.AppComponent
import com.rebrain.konstload.foodapp.di.ContextModule
import com.rebrain.konstload.foodapp.di.DaggerAppComponent
import com.rebrain.konstload.foodapp.di.ProductModeStorageModule
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
            .productModeStorageModule(ProductModeStorageModule())
            .contextModule(ContextModule(this)).build()
    }
}