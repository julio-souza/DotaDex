package com.codingwolf.dotadex.ui.util

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class LiveEvent<T> : MutableLiveData<T>() {

    private val observers: HashMap<Int, AtomicBoolean> = HashMap()

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observers[observer.hashCode()] = AtomicBoolean(false)

        super.observe(owner, Observer<T> {
            if (observers[observer.hashCode()]?.compareAndSet(true, false) == true)
                super.observe(owner, observer)
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        enableObservers()

        super.setValue(value)
    }

    override fun postValue(value: T?) {
        enableObservers()

        super.postValue(value)
    }

    @MainThread
    fun call() {
        value = null
    }

    fun asyncCall() {
        postValue(null)
    }

    private fun enableObservers() = observers.values.forEach { it.set(true) }
}
