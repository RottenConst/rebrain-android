package com.rebrain.konstload.foodapp.di

import android.content.Context
import com.rebrain.konstload.foodapp.di.components.PerApplication
import com.rebrain.konstload.foodapp.iteractor.ProductModeStorage
import com.rebrain.konstload.foodapp.iteractor.StorageModeView
import dagger.Module
import dagger.Provides

/**
 * Класс - модуль генерирующий зависимость, для поставки обьекта StorageModeView в другие классы
 */
@Module(includes = [ContextModule::class])
class ProductModeStorageModule {

    @Provides
    @PerApplication
    fun provideProductModeStorage(context: Context): StorageModeView =
        ProductModeStorage(context)
}