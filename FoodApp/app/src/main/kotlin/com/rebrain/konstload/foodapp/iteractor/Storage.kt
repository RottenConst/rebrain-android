package com.rebrain.konstload.foodapp.iteractor

/**
 * Интерфейс для дклаклорирования методов сохранения и извлечения режимов отображения в хранилеще
 */
interface Storage<Type : Enum<Type>> {

    fun save(data: Type)

    fun get(): Type
}

interface StorageModeView: Storage<ProductModeView>