package com.sprinter.viper.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.sprinter.viper.UnitTest
import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.repository.orders.OrdersRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date

class OrdersRepositoryTest : UnitTest() {

    @Test
    fun should_be_return_list_of_orders() = runBlocking {
        val result = arrayListOf(OrderEntity(123, 1, Date(), 0.344))
        val mock = mock<OrdersRepositoryImpl> {
            onBlocking { getOrderByUserId(any()) } doReturn result
        }
        assertEquals(mock.getOrderByUserId(123), result)
    }

    @Test(expected = RuntimeException::class)
    fun should_be_return_error() {
        runBlocking {
            val mock = mock<OrdersRepositoryImpl> {
                onBlocking { getOrderByUserId(any()) } doThrow RuntimeException("some exception")
            }
            mock.getOrderByUserId(0)
        }
    }
}
