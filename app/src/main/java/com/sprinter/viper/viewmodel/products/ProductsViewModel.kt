package com.sprinter.viper.viewmodel.products

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.interact.ProductsInteract
import com.sprinter.viper.interact.Response
import com.sprinter.viper.viewmodel.BaseViewModel

class ProductsViewModel(
    private val productsInteract: ProductsInteract
) : BaseViewModel() {

    private val products: MutableLiveData<Response<List<ProductEntity>>> = MutableLiveData()

    fun loadProducts(orderId: Long) {
        productsInteract.execute(orderId, products)
    }

    fun productsData(): LiveData<List<ProductEntity>> = Transformations.map(products) {
        if (it.error !== null) {
            error.postValue("Loading products error. see logs")
        }
        it.data ?: emptyList()
    }
}
