package com.sprinter.viper.repository.orders

import com.sprinter.viper.entity.OrderEntity

interface OrdersRepository {

    suspend fun getOrderByUserId(id: Long): List<OrderEntity>
}
