package com.rebrain.konstload.foodapp.di.components

import android.content.Context
import com.rebrain.konstload.foodapp.di.viewmodel.ViewModelFactoryModule
import com.rebrain.konstload.foodapp.screen.main.tabs.main.MainTabFragment
import dagger.Component

/**
 * Компонент поставляющий зависимости и ограничивающий жизненный цыкл экранов
 */
@PerScreen
@Component(dependencies = [AppComponent::class], modules = [ViewModelFactoryModule::class])
interface ScreenComponent {
    fun appContext(): Context
    fun inject(mainTabFragment: MainTabFragment)
}