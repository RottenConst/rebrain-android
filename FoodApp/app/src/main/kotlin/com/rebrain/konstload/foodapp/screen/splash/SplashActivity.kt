package com.rebrain.konstload.foodapp.screen.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rebrain.konstload.foodapp.MainActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.screen.intro.IntroActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Экран загрузки во время запуска приложения, пока пиложение загружает некоторые базовые данные,
 * что бы на первом экране был контент для просмотра пользователем.
 **/
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        CoroutineScope(Dispatchers.Main).launch {
            runNextActivity()
        }
    }

    private suspend fun runNextActivity() {
        delay(500)
        val isFirst = applicationContext
            .getSharedPreferences(R.string.first_run.toString(), Context.MODE_PRIVATE)
            .getBoolean(R.string.first_run.toString(), true)
        if (isFirst) {
            startActivity(Intent(applicationContext, IntroActivity::class.java))
        } else {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        finish()
    }
}