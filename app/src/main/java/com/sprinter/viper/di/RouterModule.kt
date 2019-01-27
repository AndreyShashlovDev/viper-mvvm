package com.sprinter.viper.di

import android.app.Application
import android.content.Context
import com.sprinter.viper.router.Router
import com.sprinter.viper.router.RouterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @Singleton
    fun providesRouter(app: Context): Router = RouterImpl(app as Application)
}
