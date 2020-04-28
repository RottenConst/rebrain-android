package com.rebrain.konstload.foodapp.repository

import android.content.Context
import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.iteractor.ProductModeStorage

/**
 * класс для получения и сохранения вида списко продуктов
 */
class ProductModeViewRepository(context: Context?) : ProductModeStorage(context) {

    /**
     * метод для сохранения вида списка продуктов
     */
    fun setModeViewProduct(enumNumber: ProductModeView) {
        saveModeView(enumNumber)
    }

    /**
     * метод для получения сохраненного вида продуктов
     */
    fun getModeViewProduct(): ProductModeView = getModeView()
}