package com.sprinter.viper.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.sprinter.viper.UnitTest
import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.repository.products.ProductsRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductsRepositoryTest : UnitTest() {

    @Test
    fun should_be_return_list_of_products() = runBlocking {
        val result = arrayListOf(ProductEntity(123, 1, "some title", 0.344))
        val mock = mock<ProductsRepositoryImpl> {
            onBlocking { getProductsByOrderId(any()) } doReturn result
        }
        assertEquals(mock.getProductsByOrderId(123), result)
    }

    @Test(expected = RuntimeException::class)
    fun should_be_return_error() {
        runBlocking {
            val mock = mock<ProductsRepositoryImpl> {
                onBlocking { getProductsByOrderId(any()) } doThrow
                        RuntimeException("some exception")
            }
            mock.getProductsByOrderId(0)
        }
    }
}
