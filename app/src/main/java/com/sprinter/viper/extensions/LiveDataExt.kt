package com.sprinter.viper.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import java.util.concurrent.CountDownLatch

// Use only for test!
@MainThread
fun <T> LiveData<T>.blockingGetValue(): T? {
    if (this.value == null) {
        val countdown = CountDownLatch(1)
        val observe = Observer<T> { countdown.countDown() }
        observeForever(observe)
        countdown.await()
        removeObserver(observe)
    }

    return this.value
}
