package com.rebrain.konstload.foodapp.screen.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.rebrain.konstload.foodapp.base.BaseActivity
import com.rebrain.konstload.foodapp.screen.main.MainActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.screen.intro.IntroActivity
import com.rebrain.konstload.foodapp.util.HelpUserProgress.showProgressHelp
import com.rebrain.konstload.foodapp.util.ProgressHelp.INTRO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Экран загрузки во время запуска приложения, пока пиложение загружает некоторые базовые данные,
 * что бы на первом экране был контент для просмотра пользователем.
 **/
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CoroutineScope(Dispatchers.Main).launch {
            runNextActivity()
        }
    }

    private suspend fun runNextActivity() {
        delay(500)
        when {
            showProgressHelp(this, INTRO) -> IntroActivity.start(this)
            else -> MainActivity.start(this)
        }
        finish()
    }

    companion object {
        fun start(context: Context) {
            startActivity(context, Intent(context, SplashActivity::class.java), null)
        }
    }
}