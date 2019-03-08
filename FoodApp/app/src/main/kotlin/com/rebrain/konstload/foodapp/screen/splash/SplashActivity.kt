package com.rebrain.konstload.foodapp.screen.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rebrain.konstload.foodapp.MainActivity
import com.rebrain.konstload.foodapp.R
import kotlinx.coroutines.*

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

    private suspend fun runNextActivity(){
            delay(500)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
    }
}