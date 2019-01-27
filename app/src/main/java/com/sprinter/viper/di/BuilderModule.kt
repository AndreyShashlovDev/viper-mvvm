package com.sprinter.viper.di

import com.sprinter.viper.ui.activity.MainActivity
import com.sprinter.viper.ui.fragment.OrdersFragment
import com.sprinter.viper.ui.fragment.ProductsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivityModule(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [OrdersFragmentModule::class])
    abstract fun bindOrdersFragmentModule(): OrdersFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProductsFragmentModule::class])
    abstract fun bindProductsFragmentModule(): ProductsFragment
}
