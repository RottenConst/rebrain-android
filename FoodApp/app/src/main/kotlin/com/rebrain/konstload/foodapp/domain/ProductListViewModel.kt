package com.rebrain.konstload.foodapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rebrain.konstload.foodapp.repository.ProductRepository
import com.rebrain.konstload.foodapp.util.Generator

/**
 * класс для фрагмента со списком товаров
 */
class ProductListViewModel(private val product: ProductRepository) : ViewModel() {

    val productListVM = product.getProductList(Generator)
}

/**
 * класс фабрика, для того что бы создовать ViewModel с конструктором,
 * поскольку ViewModelProvider не знат как и какие обьекты передавать в конструктор
 */
class ProductFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(ProductRepository()) as T
    }
}