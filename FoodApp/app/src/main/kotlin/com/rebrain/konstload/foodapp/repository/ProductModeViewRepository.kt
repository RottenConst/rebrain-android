package com.rebrain.konstload.foodapp.repository

import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.iteractor.StorageModeView

/**
 * класс для получения и сохранения вида списко продуктов
 */
class ProductModeViewRepository(private val productModeStorage: StorageModeView) {

    /**
     * метод для сохранения вида списка продуктов
     */
    fun setModeViewProduct(enumNumber: ProductModeView) {
        productModeStorage.save(enumNumber)
    }

    /**
     * метод для получения сохраненного вида продуктов
     */
    fun getModeViewProduct(): ProductModeView = productModeStorage.get()
}