package com.rebrain.konstload.foodapp.repository

import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.iteractor.ProductModeStorage

/**
 * класс для получения и сохранения вида списко продуктов
 */
class ProductModeViewRepository(private val productModeStorage: ProductModeStorage) {

    /**
     * метод для сохранения вида списка продуктов
     */
    fun setModeViewProduct(enumNumber: ProductModeView){
        productModeStorage.saveProductModeView(enumNumber)
    }

    /**
     * метод для получения сохраненного вида продуктов
     */
    fun getModeViewProduct(): ProductModeView = productModeStorage.getProductModeView()
}