package com.rebrain.konstload.foodapp.utils

import android.content.Context
import com.rebrain.konstload.foodapp.R

/**
 * обьект-помошник отвечающий за работу с подскасками и прогрессом изучения приложения пользователем
 */
object HelpUserProgress {
    //возвращает true, если приложение запускается в первый раз(значение isFirst еще не задано)
    fun isFirstRunApp(context: Context): Boolean {
        return PreferencesUtils(context).getPrefBool(R.string.first_run, true)
    }

    //задает значению SharedPreferences isFirst - false
    fun isNotRunNextTime(context: Context) {
        PreferencesUtils(context).setPrefBoolean(R.string.first_run, false)
    }
}