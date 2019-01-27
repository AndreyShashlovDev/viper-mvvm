package com.sprinter.viper.interact

import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.repository.orders.OrdersRepository

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class OrdersInteract(
    private val ordersRepository: OrdersRepository
) : Interact<List<OrderEntity>, Long>() {

    override suspend fun buildObservable(userId: Long): List<OrderEntity> =
        ordersRepository.getOrderByUserId(userId)
}
