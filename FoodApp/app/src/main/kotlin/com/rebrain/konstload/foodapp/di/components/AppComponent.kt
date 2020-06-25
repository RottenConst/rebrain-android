package com.rebrain.konstload.foodapp.di.components

import android.content.Context
import com.rebrain.konstload.foodapp.di.ContextModule
import com.rebrain.konstload.foodapp.di.ProductModeStorageModule
import com.rebrain.konstload.foodapp.di.SharedPreferencesModule
import com.rebrain.konstload.foodapp.iteractor.StorageModeView
import dagger.Component

/**
 * Компонент - корень дерева зависимостей, связующее звено графа зависимостей
 */
@PerApplication
@Component(modules = [ContextModule::class, ProductModeStorageModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun appContext(): Context
    fun productModeStorage(): StorageModeView
}