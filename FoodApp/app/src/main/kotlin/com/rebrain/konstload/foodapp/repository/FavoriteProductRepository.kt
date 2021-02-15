package com.rebrain.konstload.foodapp.repository

import com.rebrain.konstload.foodapp.domain.Product
import javax.inject.Inject

class FavoriteProductRepository @Inject constructor(){

    fun setFavoriteProduct(product: Product) {
        product.favorite = !product.favorite
    }

    fun getFavoriteProducts(products: List<Product>): List<Product> {
        val favorites = mutableListOf<Product>()
        for (favorite in products) {
            if (favorite.favorite)
                favorites.add(favorite)
        }
        return favorites
    }
}