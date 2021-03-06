package com.rebrain.konstload.foodapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rebrain.konstload.foodapp.di.components.PerScreen
import com.rebrain.konstload.foodapp.repository.ProductRepository
import com.rebrain.konstload.foodapp.util.Generator
import javax.inject.Inject

/**
 * класс для фрагмента со списком товаров
 */
@PerScreen
class ProductListViewModel @Inject constructor(private val productRepo: ProductRepository) :
    ViewModel() {

    private val mProductLiveData: MutableLiveData<List<Product>> = MutableLiveData()
    val productLiveData: LiveData<List<Product>> get() = mProductLiveData

    init {
        mProductLiveData.value = productRepo.getProductList(Generator)
    }

    fun refreshListProduct() {
        mProductLiveData.value = productRepo.getProductList(Generator)
    }
}

