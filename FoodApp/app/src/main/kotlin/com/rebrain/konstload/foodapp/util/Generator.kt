package com.rebrain.konstload.foodapp.util

import com.rebrain.konstload.foodapp.domain.Product
import kotlin.random.Random

/**
 * обьект предоставляющий методы для генерации необходимых сущностей
 **/
object Generator {

    fun getProducts(): List<Product> {
        val listProducts = mutableListOf<Product>()
        var x = Random.nextInt(50)
        while (listProducts.size != 20) {
            listProducts.add(Product(id = x++, name = "Product${Random.nextInt(100)}"))
        }
        if (x % 2 == 0) {
            listProducts.sortBy { it.id }
        } else listProducts.sortBy { it.name }
        return listProducts.toList()
    }
}