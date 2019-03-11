package com.rebrain.konstload.foodapp.utils

import android.content.Context
import com.rebrain.konstload.foodapp.R

/**
  * Утилитные методы для работы с SharedPreferences
  **/

//возвращает true, если приложение запускается в первый раз(значение isFirst еще не задано)
fun isFirstRunApp(context: Context): Boolean {
    return context.getSharedPreferences(R.string.first_run.toString(), Context.MODE_PRIVATE)
        .getBoolean(R.string.first_run.toString(), true)
}

//задает значению SharedPreferences isFirst - false
fun notFirstRunApp(context: Context) {
    context.getSharedPreferences(R.string.first_run.toString(), Context.MODE_PRIVATE)
        .edit()
        .putBoolean(R.string.first_run.toString(), false)
        .apply()
}