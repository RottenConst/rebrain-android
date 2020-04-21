package com.rebrain.konstload.foodapp.iteractor

import android.content.Context

/**
 * класс для сохранения режима отображения списка продуктов в SharedPreferences
 */
const val MODE_VIEW = "PRODUCT_MODE_VIEW"

class ProductModeStorage {

    /**
     * метод для сохранения режима отображения продуктов
     */
    fun saveProductModeView(viewModeProduct: Boolean, context: Context?) {
        val editor = context?.getSharedPreferences(MODE_VIEW, Context.MODE_PRIVATE)?.edit()
        editor?.putBoolean(MODE_VIEW, viewModeProduct)
        editor?.apply()
    }

    /**
     * метод для получения режима отображения списка продуктов
     */
    fun getProductModeView(context: Context?): Boolean? {
        val savedMode = context?.getSharedPreferences(MODE_VIEW, Context.MODE_PRIVATE)
        return savedMode?.getBoolean(MODE_VIEW, true)
    }
}