package com.sprinter.viper.interact

import android.arch.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.random.Random

abstract class Interact<Result, Parameter> {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    protected abstract suspend fun buildObservable(parameter: Parameter): Result

    fun execute(parameter: Parameter, liveData: MutableLiveData<Response<Result>>) {
        scope.launch {
            try {
                val rnd: Long = Random.nextLong(5000)
                Thread.sleep(rnd)
                val result = buildObservable(parameter)
                liveData.postValue(Response(result))
            } catch (e: Exception) {
                Timber.d("error ${e.message}")
                liveData.postValue(Response(error = e))
            }
        }
    }
}
