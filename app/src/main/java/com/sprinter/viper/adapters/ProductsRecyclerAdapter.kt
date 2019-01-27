package com.sprinter.viper.adapters

import android.view.ViewGroup
import com.sprinter.viper.R
import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.extensions.inflate
import com.sprinter.viper.holders.ProductHolder

class ProductsRecyclerAdapter : AbstractRecyclerAdapter<ProductEntity, ProductHolder>(emptyList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
        ProductHolder(parent.inflate(R.layout.li_product))
}
