package com.rebrain.konstload.foodapp.di

import android.content.Context
import android.content.SharedPreferences
import com.rebrain.konstload.foodapp.di.components.PerApplication
import dagger.Module
import dagger.Provides

/**
 * Класс - модуль генерирующий зависимость, для поставки обьекта SharedPreferences в другие классы
 */
@Module(includes = [ContextModule::class])
class SharedPreferencesModule(val name: String) {

    @Provides
    @PerApplication
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)
}