package com.rebrain.konstload.foodapp.iteractor

import android.content.Context
import com.rebrain.konstload.foodapp.R

/**
 * класс для сохранения режима отображения списка продуктов в SharedPreferences
 */
const val MODE_VIEW = "PRODUCT_MODE_VIEW"

class ProductModeStorage(context: Context?) {

    private val preferencesViewMode = context?.getSharedPreferences(MODE_VIEW, Context.MODE_PRIVATE)

    /**
     * метод для сохранения режима отображения продуктов
     */
    fun saveProductModeView(viewModeProduct: ProductModeView) {
        val editor = preferencesViewMode?.edit()
        editor?.putInt(MODE_VIEW, viewModeProduct.layout)
        editor?.apply()
    }

    /**
     * метод для получения режима отображения списка продуктов
     */
    fun getProductModeView(): ProductModeView = when(preferencesViewMode?.getInt(MODE_VIEW, 0)) {
        R.layout.layout_list_item_product -> ProductModeView.LINEAR_MODE_VIEW_PRODUCT
        R.layout.layout_grid_item_product -> ProductModeView.GRID_MODE_VIEW_PRODUCT
        else -> ProductModeView.LINEAR_MODE_VIEW_PRODUCT
    }
}

enum class ProductModeView(val layout: Int) {
    LINEAR_MODE_VIEW_PRODUCT(R.layout.layout_list_item_product),
    GRID_MODE_VIEW_PRODUCT(R.layout.layout_grid_item_product)
}