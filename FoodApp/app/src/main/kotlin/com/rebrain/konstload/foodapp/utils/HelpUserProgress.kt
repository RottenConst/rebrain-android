package com.rebrain.konstload.foodapp.utils

import android.content.Context

/**
 * enum-класс с видами подсказказок для пользователя
 */
enum class ProgressHelp {
    INTRO
}

/**
 * обьект-помошник отвечающий за работу с подскасками и прогрессом изучения приложения пользователем
 */
object HelpUserProgress {
    //задает значене подсказам в SharedPreferences, будут они показываться или нет
    fun setProgressHelp(context: Context, progress: ProgressHelp, value: Boolean) {
        PreferencesUtils(context).setPrefBoolean(progress.ordinal, value)
    }

    //возвращает true, если подсказка запускается в первый раз (будет показана)
    fun showProgressHelp(context: Context, progress: ProgressHelp): Boolean =
        PreferencesUtils(context).getPrefBool(progress.ordinal, true)
}