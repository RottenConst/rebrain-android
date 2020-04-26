package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.domain.ProductFactory
import com.rebrain.konstload.foodapp.domain.ProductListViewModel
import com.rebrain.konstload.foodapp.iteractor.ProductModeStorage
import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.repository.ProductModeViewRepository
import com.rebrain.konstload.foodapp.screen.main.list_main.ListPriceAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.jetbrains.anko.support.v4.toast

/**
 * класс фрагмент для реализации главного таба
 */
class MainTabFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private val adapter = ListPriceAdapter()
    private val factory = ProductFactory()
    private val productModeRepo by lazy {
        ProductModeViewRepository(ProductModeStorage(context)) }
    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            factory
        )[ProductListViewModel::class.java]
    }

    override fun getName(): String {
        return "MainTabFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter.priceModeView = productModeRepo.getModeViewProduct()
        activity?.main_button_tab?.switchColorButton(true)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.fragmentManager = fragmentManager
        swipe_refresh_product.setOnRefreshListener(this)
        initToolbar()
        initRv()
        viewModel.productLiveData.observe(this, Observer {
            addGeneratedProduct(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.swich_view_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (adapter.priceModeView) {
            ProductModeView.LINEAR_MODE_VIEW_PRODUCT -> {
                adapter.priceModeView = ProductModeView.GRID_MODE_VIEW_PRODUCT
                item.setIcon(R.drawable.ic_menu_icon_linear_list)
                initRv()
                true
            }
            ProductModeView.GRID_MODE_VIEW_PRODUCT -> {
                adapter.priceModeView = ProductModeView.LINEAR_MODE_VIEW_PRODUCT
                item.setIcon(R.drawable.ic_menu_icon_grid_list)
                initRv()
                false
            }
        }

    override fun onPause() {
        super.onPause()
        productModeRepo.setModeViewProduct(adapter.priceModeView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.main_button_tab?.switchColorButton(false)
    }

    override fun onRefresh() {
        swipe_refresh_product.isRefreshing = false
        viewModel.refreshListProduct()
    }

    private fun initRv() {
        when (adapter.priceModeView) {
            ProductModeView.LINEAR_MODE_VIEW_PRODUCT -> recycler_list_product.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            ProductModeView.GRID_MODE_VIEW_PRODUCT -> recycler_list_product.layoutManager =
                GridLayoutManager(activity, 2)
        }
        adapter.onProductClick = { toast("id ${it.id}") }
        adapter.notifyDataSetChanged()
        recycler_list_product.adapter = adapter
    }

    private fun addGeneratedProduct(products: List<Product>) {
        adapter.products.clear()
        adapter.products.addAll(products)
        adapter.notifyDataSetChanged()
    }

    private fun initToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(food_toolbar)
        activity.supportActionBar?.setTitle(R.string.toolbar_text_main)
    }

    companion object {
        fun newInstance(): MainTabFragment {
            return MainTabFragment()
        }
    }
}