package com.rebrain.konstload.foodapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rebrain.konstload.foodapp.repository.ProductRepository
import com.rebrain.konstload.foodapp.util.Generator

/**
 * класс для фрагмента со списком товаров
 */
class ProductListViewModel(private val productRepo: ProductRepository) : ViewModel() {

    private val mProductLiveData: MutableLiveData<List<Product>> = MutableLiveData()
    val productLiveData: LiveData<List<Product>> get() = mProductLiveData

    init {
        mProductLiveData.value = productRepo.getProductList(Generator)
    }

    fun refreshListProduct() {
        mProductLiveData.value = productRepo.getProductList(Generator)
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