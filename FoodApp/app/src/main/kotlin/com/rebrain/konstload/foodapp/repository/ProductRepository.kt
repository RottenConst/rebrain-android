package com.rebrain.konstload.foodapp.repository

import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.util.Generator

/**
 * класс для получения списка продуктов
 */
class ProductRepository {

    fun getProductList(generator: Generator): List<Product>{
        return generator.getProducts()
    }
}