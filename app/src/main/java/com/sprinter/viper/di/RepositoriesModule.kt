package com.sprinter.viper.di

import android.content.Context
import com.sprinter.viper.repository.orders.OrdersRepository
import com.sprinter.viper.repository.orders.OrdersRepositoryImpl
import com.sprinter.viper.repository.products.ProductsRepository
import com.sprinter.viper.repository.products.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Singleton
    @Provides
    fun provideProductsRepository(context: Context): ProductsRepository =
        ProductsRepositoryImpl(context)

    @Singleton
    @Provides
    fun provideOrdersRepository(context: Context): OrdersRepository =
        OrdersRepositoryImpl(context)
}
