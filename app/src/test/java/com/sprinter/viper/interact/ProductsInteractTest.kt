package com.sprinter.viper.interact

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.sprinter.viper.UnitTest
import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.extensions.blockingGetValue
import com.sprinter.viper.repository.products.ProductsRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductsInteractTest : UnitTest() {

    private lateinit var repository: ProductsRepositoryImpl
    private val result = arrayListOf(ProductEntity(123, 1, "some title", 0.344))
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        repository = mock {
            onBlocking { getProductsByOrderId(any()) } doReturn result
        }
    }

    @Test
    fun should_be_return_list_of_products() {
        val interact = ProductsInteract(repository)
        val data: MutableLiveData<Response<List<ProductEntity>>> = MutableLiveData()
        interact.execute(123, data)

        assertNotNull(data.blockingGetValue())
        assertEquals(data.value!!.data, result)
    }

    @Test
    fun should_be_return_exception() {
        val exception = RuntimeException("can't load data")
        val brokenRepository: ProductsRepositoryImpl = mock {
            onBlocking { getProductsByOrderId(any()) } doThrow exception
        }

        val interact = ProductsInteract(brokenRepository)
        val data: MutableLiveData<Response<List<ProductEntity>>> = MutableLiveData()
        interact.execute(123, data)

        assertNotNull(data.blockingGetValue())
        assert(data.value!!.data == null)
        assertEquals(data.value!!.error, exception)
    }
}
