package com.rebrain.konstload.foodapp.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

/**
 * абстрактный базовый класс-фрагмент от которого наследуются все остальные фрагменты
 */
abstract class BaseFragment : Fragment() {

    abstract fun getName(): String

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.d("%s onAttach", getName())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("%s onCreate", getName())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Timber.d("%s onCreateView", getName())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("%s onViewCreated", getName())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("%s onActivityCreated", getName())
    }

    override fun onStart() {
        super.onStart()
        Timber.d("%s onStart", getName())
    }

    override fun onResume() {
        super.onResume()
        Timber.d("%s onResume", getName())
    }

    override fun onPause() {
        super.onPause()
        Timber.d("%s onPause", getName())
    }

    override fun onStop() {
        super.onStop()
        Timber.d("%s onStop", getName())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("%s onDestroyView", getName())
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("%s onDestroy", getName())
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("%s onDetach", getName())
    }
}