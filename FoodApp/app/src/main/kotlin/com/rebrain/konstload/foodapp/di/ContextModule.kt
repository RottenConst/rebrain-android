package com.rebrain.konstload.foodapp.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Класс - модуль генерирующий зависимость, для поставки обьекта Context
 */
@Module
class ContextModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context.applicationContext
}