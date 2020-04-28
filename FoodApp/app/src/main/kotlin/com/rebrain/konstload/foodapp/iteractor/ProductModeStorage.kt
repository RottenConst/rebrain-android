package com.rebrain.konstload.foodapp.iteractor

import android.content.Context

/**
 * класс для сохранения режима отображения списка продуктов в SharedPreferences
 */
const val MODE_VIEW = "PRODUCT_MODE_VIEW"

open class ProductModeStorage(final override val context: Context?) : IStorageModeView<ProductModeView> {

    private val preferencesViewMode = context?.getSharedPreferences(MODE_VIEW, Context.MODE_PRIVATE)

    /**
     * метод для сохранения режима отображения продуктов
     */
    override fun saveModeView(modeView: ProductModeView) {
        val editor = preferencesViewMode?.edit()
        editor?.putInt(MODE_VIEW, modeView.id)
        editor?.apply()
    }

    /**
     * метод для получения режима отображения списка продуктов
     */
    override fun getModeView(): ProductModeView = ProductModeView.getById(preferencesViewMode?.getInt(
        MODE_VIEW, 0))
}

enum class ProductModeView(val id: Int) {
    LINEAR_MODE_VIEW_PRODUCT(0),
    GRID_MODE_VIEW_PRODUCT(1);

    companion object {
        fun getById(id: Int?) = values().find { it.id == id } ?: LINEAR_MODE_VIEW_PRODUCT
    }
}