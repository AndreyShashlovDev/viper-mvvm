package com.sprinter.viper

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.sprinter.viper.di.DaggerAppComponent
import com.sprinter.viper.router.Router
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class AppDelegate : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var router: Router

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? = dispatchingAndroidActivityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
        dispatchingAndroidFragmentInjector
}
