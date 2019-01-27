package com.sprinter.viper.ui.activity

import android.os.Bundle
import com.sprinter.viper.R
import com.sprinter.viper.router.Router
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        setContentView(R.layout.act_main)

        router.openOrdersPage()
    }
}
