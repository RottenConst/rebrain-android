package com.rebrain.konstload.foodapp.di

import android.content.Context
import com.rebrain.konstload.foodapp.di.components.PerApplication
import dagger.Module
import dagger.Provides

/**
 * Класс - модуль генерирующий зависимость, для поставки обьекта Context
 */
@Module
class ContextModule(val context: Context) {

    @Provides
    @PerApplication
    fun provideContext(): Context = context.applicationContext
}