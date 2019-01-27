package com.sprinter.viper.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprinter.viper.R
import com.sprinter.viper.adapters.ProductsRecyclerAdapter
import com.sprinter.viper.entity.ProductEntity
import com.sprinter.viper.viewmodel.products.ProductsViewModel
import com.sprinter.viper.viewmodel.products.ProductsViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fmt_product.*
import timber.log.Timber
import javax.inject.Inject

class ProductsFragment : Fragment() {

    companion object {

        val FRAGMENT_TAG: String
            get() = ProductsFragment::class.java.simpleName

        private const val KEY_ORDER_ID: String = "KEY_ORDER_ID"

        fun newInstance(orderId: Long): ProductsFragment {
            val args = Bundle()
            args.putLong(KEY_ORDER_ID, orderId)

            val fragment = ProductsFragment()
            fragment.arguments = args

            return fragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ProductsViewModelFactory

    lateinit var viewModel: ProductsViewModel
    private val productsRecyclerAdapter = ProductsRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ProductsViewModel::class.java)
        viewModel.productsData().observe(this, Observer { list -> this.setProducts(list) })
        viewModel.errorData().observe(this, Observer { message -> Timber.d(message) })
    }

    private fun setProducts(list: List<ProductEntity>?) {
        productsRecyclerAdapter.data = list ?: emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fmt_product, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orderId = arguments?.getLong(KEY_ORDER_ID) ?: 0

        viewModel.loadProducts(orderId)

        fmtProductsList.layoutManager = LinearLayoutManager(context)
        fmtProductsList.adapter = productsRecyclerAdapter
    }
}
