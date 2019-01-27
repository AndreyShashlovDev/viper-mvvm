package com.sprinter.viper.repository.products

import com.sprinter.viper.entity.ProductEntity

interface ProductsRepository {

    suspend fun getProductsByOrderId(orderId: Long): List<ProductEntity>
}
