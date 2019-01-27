package com.sprinter.viper.di

import com.sprinter.viper.interact.OrdersInteract
import com.sprinter.viper.repository.orders.OrdersRepository
import com.sprinter.viper.router.Router
import com.sprinter.viper.viewmodel.orders.OrdersViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class OrdersFragmentModule {

    @Provides
    fun provideOrdersViewModelFactory(
        ordersInteract: OrdersInteract,
        router: Router
    ): OrdersViewModelFactory =
        OrdersViewModelFactory(ordersInteract, router)

    @Provides
    fun provideOrdersInteract(ordersRepository: OrdersRepository): OrdersInteract =
        OrdersInteract(ordersRepository)
}
