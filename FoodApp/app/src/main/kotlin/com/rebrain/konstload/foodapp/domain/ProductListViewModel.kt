package com.rebrain.konstload.foodapp.domain

import androidx.lifecycle.ViewModel
import com.rebrain.konstload.foodapp.util.Generator

/**
 * класс для фрагмента со списком товаров
 */
class ProductListViewModel : ViewModel() {

    val productListVM = Generator.getProducts()
}