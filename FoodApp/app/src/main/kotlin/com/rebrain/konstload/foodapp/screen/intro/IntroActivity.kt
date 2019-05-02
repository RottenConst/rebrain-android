package com.rebrain.konstload.foodapp.screen.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.utils.HelpUserProgress.setProgressHelp
import com.rebrain.konstload.foodapp.utils.ProgressHelp.INTRO
import timber.log.Timber

/**
 * Интро-экран с кратким описанием возможностей приложения, запускается 1 раз, при первом запуске приложения.
 **/
class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setProgressHelp(this, INTRO, false)

        Timber.d("onCreate")
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

    companion object {
        fun start(context: Context) {
            startActivity(context, Intent(context, IntroActivity::class.java), null)
        }
    }
}