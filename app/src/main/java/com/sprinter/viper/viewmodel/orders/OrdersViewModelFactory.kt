package com.sprinter.viper.viewmodel.orders

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sprinter.viper.interact.OrdersInteract
import com.sprinter.viper.router.Router

class OrdersViewModelFactory(
    private val ordersInteract: OrdersInteract,
    private val router: Router
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = OrdersViewModel(
        ordersInteract,
        router
    ) as T
}
