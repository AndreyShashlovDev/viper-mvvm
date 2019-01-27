package com.sprinter.viper.ui.activity

import android.support.v7.app.AppCompatActivity
import com.sprinter.viper.extensions.hideSoftKeyboard

abstract class BaseActivity : AppCompatActivity(), BaseActivityView {

    private var backPressedListener: BaseActivityView.OnBackPressedListener? = null

    override fun setOnBackPressedListener(listener: BaseActivityView.OnBackPressedListener?) {
        backPressedListener = listener
    }

    override fun onBackPressed() {
        this.hideSoftKeyboard()
        if (backPressedListener?.onBackPressed() == true) {
            super.onBackPressed()
        }
    }
}
