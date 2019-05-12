package com.rebrain.konstload.foodapp.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

open class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.d("%s onAttach", javaClass.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("%s onCreate", javaClass.simpleName)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Timber.d("%s onCreateView", javaClass.simpleName)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("%s onActivityCreated", javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("%s onStart", javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Timber.d("%s onResume", javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Timber.d("%s onPause", javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Timber.d("%s onStop", javaClass.simpleName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("%s onDestroyView", javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("%s onDestroy", javaClass.simpleName)
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("%s onDetach", javaClass.simpleName)
    }
}