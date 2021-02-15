package com.rebrain.konstload.foodapp.domain

/**
 * класс предоставляемого продукта
 **/
data class Product(
    val id: Int,
    val name: String,
    var favorite: Boolean = false
)