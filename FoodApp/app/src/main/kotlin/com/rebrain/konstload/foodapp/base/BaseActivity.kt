package com.rebrain.konstload.foodapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import timber.log.Timber

/**
 * Базовая активность приложения от которой наследуются все остальные
 **/
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("%s onCreate", localClassName)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("%s onStart", localClassName)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("%s onResume", localClassName)
    }

    override fun onPause() {
        super.onPause()
        Timber.d("%s onPause", localClassName)
    }

    override fun onStop() {
        super.onStop()
        Timber.d("%s onStop", localClassName)
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("%s onRestart", localClassName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("%s onDestroy", localClassName)
    }
}