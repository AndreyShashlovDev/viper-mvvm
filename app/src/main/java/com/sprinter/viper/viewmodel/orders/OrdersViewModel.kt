package com.sprinter.viper.viewmodel.orders

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.interact.OrdersInteract
import com.sprinter.viper.interact.Response
import com.sprinter.viper.router.Router
import com.sprinter.viper.viewmodel.BaseViewModel

class OrdersViewModel(
    private val ordersInteract: OrdersInteract,
    private val router: Router
) : BaseViewModel() {

    private val orders: MutableLiveData<Response<List<OrderEntity>>> = MutableLiveData()

    fun loadOrders() {
        ordersInteract.execute(0, orders)
    }

    fun ordersData(): LiveData<List<OrderEntity>> = Transformations.map(orders) {
        if (it.error !== null) {
            error.postValue("Loading orders error. see logs")
        }
        it.data ?: emptyList()
    }

    fun onOrderItemClick(position: Int) {
        val orderId = orders.value?.data?.get(position)?.id ?: 0

        router.openProductsPage(orderId)
    }
}
