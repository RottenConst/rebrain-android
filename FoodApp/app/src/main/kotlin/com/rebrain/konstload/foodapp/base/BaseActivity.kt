package com.rebrain.konstload.foodapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.rebrain.konstload.foodapp.util.Logger
import timber.log.Timber

/**
 * Базовая активность приложения от которой наследуются все остальные
 **/
open class BaseActivity : AppCompatActivity() {

    private lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger = Logger()
        lifecycle.addObserver(logger)
    }
}