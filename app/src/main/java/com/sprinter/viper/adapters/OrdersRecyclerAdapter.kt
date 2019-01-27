package com.sprinter.viper.adapters

import android.view.ViewGroup
import com.sprinter.viper.R
import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.extensions.inflate
import com.sprinter.viper.holders.OrderHolder

class OrdersRecyclerAdapter : AbstractRecyclerAdapter<OrderEntity, OrderHolder>(emptyList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder =
        OrderHolder(parent.inflate(R.layout.li_order))
}
