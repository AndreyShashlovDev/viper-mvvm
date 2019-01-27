package com.sprinter.viper.repository.orders

import android.content.Context
import com.sprinter.viper.entity.OrderEntity
import java.util.Date

class OrdersRepositoryImpl(private val context: Context) : OrdersRepository {

    override suspend fun getOrderByUserId(id: Long): List<OrderEntity> {
        return arrayListOf(OrderEntity(1, id, Date(), 100.0))
    }
}
