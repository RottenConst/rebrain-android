package com.rebrain.konstload.foodapp.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class Logger : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun getLog(owner: LifecycleOwner, event: Lifecycle.Event){
        val message = "${owner.javaClass.simpleName} $event"
        Timber.d(message)
    }
}