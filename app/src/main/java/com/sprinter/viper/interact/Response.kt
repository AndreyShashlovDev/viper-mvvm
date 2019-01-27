package com.sprinter.viper.interact

data class Response<T>(val data: T? = null, val error: Throwable? = null)
