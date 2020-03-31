package com.rebrain.konstload.foodapp.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rebrain.konstload.foodapp.repository.ProductRepository
import com.rebrain.konstload.foodapp.util.Generator

/**
 * класс для фрагмента со списком товаров
 */
class ProductListViewModel(private val productRepo: ProductRepository) : ViewModel() {

    private val productLiveData: MutableLiveData<List<Product>> = MutableLiveData()

    init {
        productLiveData.value = productRepo.getProductList(Generator)
    }

    fun getListProduct() : MutableLiveData<List<Product>> = productLiveData

    fun refreshListProduct() : MutableLiveData<List<Product>> {
        productLiveData.value = productRepo.getProductList(Generator)
        return productLiveData
    }
}

/**
 * класс фабрика, для того что бы создовать ViewModel с конструктором,
 * поскольку ViewModelProvider не знает как и какие обьекты передавать в конструктор
 */
class ProductFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(ProductRepository()) as T
    }
}