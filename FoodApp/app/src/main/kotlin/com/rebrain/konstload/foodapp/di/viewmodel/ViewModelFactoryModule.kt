package com.rebrain.konstload.foodapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rebrain.konstload.foodapp.di.components.PerScreen
import com.rebrain.konstload.foodapp.domain.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Модуль где связываем вью модели в коллекцию
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    @PerScreen
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindProductListViewModel(productListViewModel: ProductListViewModel): ViewModel
}