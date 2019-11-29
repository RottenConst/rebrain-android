package com.rebrain.konstload.foodapp.util

import com.rebrain.konstload.foodapp.R
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

    val images = listOf(
        R.drawable.img_one,
        R.drawable.img_two,
        R.drawable.img_three,
        R.drawable.img_four,
        R.drawable.img_five,
        R.drawable.img_six,
        R.drawable.img_seven,
        R.drawable.img_eight,
        R.drawable.img_nine,
        R.drawable.img_ten)
}