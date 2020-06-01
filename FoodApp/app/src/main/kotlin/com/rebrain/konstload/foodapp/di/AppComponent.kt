package com.rebrain.konstload.foodapp.di

import android.content.Context
import com.rebrain.konstload.foodapp.iteractor.StorageModeView
import com.rebrain.konstload.foodapp.screen.main.tabs.main.MainTabFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент - корень дерева зависимостей, связующее звено графа зависимостей
 */
@Singleton
@Component(modules = [ProductModeStorageModule::class, SharedPreferencesModule::class, ViewModelFactoryModule::class])
interface AppComponent {
    fun productModeStorage(): StorageModeView
    fun appContext(): Context
    fun inject(mainTabFragment: MainTabFragment)
}