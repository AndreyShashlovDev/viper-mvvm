package com.sprinter.viper.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprinter.viper.R
import com.sprinter.viper.adapters.ItemClickListener
import com.sprinter.viper.adapters.OrdersRecyclerAdapter
import com.sprinter.viper.entity.OrderEntity
import com.sprinter.viper.viewmodel.orders.OrdersViewModel
import com.sprinter.viper.viewmodel.orders.OrdersViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fmt_orders.*
import timber.log.Timber
import javax.inject.Inject

class OrdersFragment : Fragment() {

    companion object {

        val FRAGMENT_TAG: String
            get() = OrdersFragment::class.java.simpleName

        fun newInstance(): OrdersFragment = OrdersFragment()
    }

    @Inject
    lateinit var viewModelFactory: OrdersViewModelFactory

    lateinit var viewModel: OrdersViewModel
    private val ordersRecyclerAdapter: OrdersRecyclerAdapter = OrdersRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(OrdersViewModel::class.java)
        viewModel.ordersData().observe(this, Observer { list -> this.setOrders(list) })
        viewModel.errorData().observe(this, Observer { message -> Timber.d(message) })
    }

    private fun setOrders(list: List<OrderEntity>?) {
        ordersRecyclerAdapter.data = list ?: emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fmt_orders, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadOrders()
        fmtOrdersList.layoutManager = LinearLayoutManager(context)
        fmtOrdersList.adapter = ordersRecyclerAdapter

        ordersRecyclerAdapter.setClickListener(object : ItemClickListener {
            override fun onItemClick(position: Int, @IdRes id: Int, payload: String?) {
                viewModel.onOrderItemClick(position)
            }
        })
    }
}
