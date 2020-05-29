package com.rebrain.konstload.foodapp.di

import android.content.Context
import com.rebrain.konstload.foodapp.iteractor.StorageModeView
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент - корень дерева зависимостей, связующее звено графа зависимостей
 */
@Singleton
@Component(modules = [ProductModeStorageModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun productModeStorage(): StorageModeView
    fun appContext(): Context
}