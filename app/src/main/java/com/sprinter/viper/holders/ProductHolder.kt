package com.sprinter.viper.holders

import android.view.View
import com.sprinter.viper.entity.ProductEntity
import kotlinx.android.synthetic.main.li_product.view.*

class ProductHolder constructor(itemView: View) : AbstractHolder<ProductEntity>(itemView) {

    override fun bind(model: ProductEntity) {
        super.bind(model)
        itemView.liProductTextId.text = model.id.toString()
        itemView.liProductTextTitle.text = model.title.toString()
        itemView.liProductTextPrice.text = model.price.toString()
    }
}
