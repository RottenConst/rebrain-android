package com.rebrain.konstload.foodapp.screen.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.rebrain.konstload.foodapp.MainActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.screen.intro.IntroActivity
import com.rebrain.konstload.foodapp.utils.HelpUserProgress.showProgressHelp
import com.rebrain.konstload.foodapp.utils.ProgressHelp.INTRO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Экран загрузки во время запуска приложения, пока пиложение загружает некоторые базовые данные,
 * что бы на первом экране был контент для просмотра пользователем.
 **/
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timber.d("onCreate")
        CoroutineScope(Dispatchers.Main).launch {
            runNextActivity()
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
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