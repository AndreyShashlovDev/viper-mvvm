package com.sprinter.viper.di

import android.app.Application
import android.content.Context
import com.sprinter.viper.router.Router
import com.sprinter.viper.router.RouterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesAppContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun providesRouter(app: Application): Router = RouterImpl(app)
}
