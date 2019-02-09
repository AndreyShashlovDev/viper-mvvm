package com.sprinter.viper.interact

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.sprinter.viper.UnitTest
import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.extensions.blockingGetValue
import com.sprinter.viper.repository.orders.OrdersRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date

class OrdersInteractTest : UnitTest() {

    private lateinit var repository: OrdersRepositoryImpl
    private val result = arrayListOf(OrderEntity(123, 1, Date(), 0.344))
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        repository = mock {
            onBlocking { getOrderByUserId(any()) } doReturn result
        }
    }

    @Test
    fun should_be_return_list_of_orders() {
        val interact = OrdersInteract(repository)
        val data: MutableLiveData<Response<List<OrderEntity>>> = MutableLiveData()
        interact.execute(123, data)

        assertNotNull(data.blockingGetValue())
        assertEquals(data.value!!.data, result)
    }

    @Test
    fun should_be_return_exception() {
        val exception = RuntimeException("can't load data")
        val brokenRepository: OrdersRepositoryImpl = mock {
            onBlocking { getOrderByUserId(any()) } doThrow exception
        }

        val interact = OrdersInteract(brokenRepository)
        val data: MutableLiveData<Response<List<OrderEntity>>> = MutableLiveData()
        interact.execute(123, data)

        assertNotNull(data.blockingGetValue())
        assert(data.value!!.data == null)
        assertEquals(data.value!!.error, exception)
    }
}
