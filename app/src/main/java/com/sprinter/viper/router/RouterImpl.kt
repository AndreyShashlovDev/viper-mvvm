package com.sprinter.viper.router

import android.app.Application
import com.sprinter.viper.ui.fragment.OrdersFragment
import com.sprinter.viper.ui.fragment.ProductsFragment

class RouterImpl(private val app: Application) : BaseRouter(app), Router {

    override fun openOrdersPage() {
        changeFragment(OrdersFragment.newInstance(), OrdersFragment.FRAGMENT_TAG, true)
    }

    override fun openProductsPage(orderId: Long) {
        changeFragment(ProductsFragment.newInstance(orderId), ProductsFragment.FRAGMENT_TAG, false)
    }
}
