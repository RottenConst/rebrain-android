package com.rebrain.konstload.foodapp.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context.applicationContext
}