package com.rebrain.konstload.foodapp.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebrain.konstload.foodapp.util.Logger
import timber.log.Timber

/**
 * абстрактный базовый класс-фрагмент от которого наследуются все остальные фрагменты
 */
abstract class BaseFragment : Fragment() {

    abstract fun getName(): String
    private lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger = Logger()
        lifecycle.addObserver(logger)
    }
}