package com.sprinter.viper.interact

import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.repository.products.ProductsRepository

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class ProductsInteract(
    private val productsRepository: ProductsRepository
) : Interact<List<ProductEntity>, Long>() {

    override suspend fun buildObservable(orderId: Long): List<ProductEntity> =
        productsRepository.getProductsByOrderId(orderId)
}
