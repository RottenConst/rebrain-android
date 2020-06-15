package com.rebrain.konstload.foodapp.repository

import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.util.Generator
import javax.inject.Inject

/**
 * класс для получения списка продуктов
 */
class ProductRepository @Inject constructor() {

    /**
     * метод для получения списка продуктов
     */
    fun getProductList(generator: Generator): List<Product>{
        return generator.getProducts()
    }
}