package com.sprinter.viper.ui.activity

interface BaseActivityView {

    interface OnBackPressedListener {

        fun onBackPressed(): Boolean
    }

    fun setOnBackPressedListener(listener: OnBackPressedListener?)
}
