package com.sprinter.viper.holders

import android.view.View
import com.sprinter.viper.entity.OrderEntity
import kotlinx.android.synthetic.main.li_order.view.*

class OrderHolder constructor(itemView: View) : AbstractHolder<OrderEntity>(itemView) {

    override fun bind(model: OrderEntity) {
        super.bind(model)
        itemView.liOrderTextId.text = model.id.toString()
        itemView.liOrderTextDate.text = model.date.toString()
        itemView.liOrderTextSum.text = model.sum.toString()
    }
}
