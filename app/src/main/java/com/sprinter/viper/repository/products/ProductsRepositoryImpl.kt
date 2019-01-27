package com.sprinter.viper.repository.products

import android.content.Context
import com.sprinter.viper.entity.ProductEntity

class ProductsRepositoryImpl(private val context: Context) : ProductsRepository {

    override suspend fun getProductsByOrderId(orderId: Long): List<ProductEntity> =
        arrayListOf(
            ProductEntity(1, 1, "Product 1", 10.0)
        ).filter { it.orderId == orderId }
}
