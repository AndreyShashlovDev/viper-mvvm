package com.sprinter.viper.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val error: MutableLiveData<String> = MutableLiveData()
    protected val progress: MutableLiveData<Boolean> = MutableLiveData()

    fun errorData(): LiveData<String> = error
}
