package com.sprinter.viper.viewmodel.products

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sprinter.viper.interact.ProductsInteract

class ProductsViewModelFactory(
    private val productsInteract: ProductsInteract
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ProductsViewModel(
        productsInteract
    ) as T
}
