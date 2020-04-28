package com.rebrain.konstload.foodapp.iteractor

import android.content.Context

/**
 * Интерфейс для дклаклорирования методов сохранения и извлечения режимов отображения в хранилеще
 */
interface IStorageModeView<Type : Enum<Type>> {

    val context: Context?

    fun saveModeView(modeView: Type)

    fun getModeView(): Enum<Type>

}