package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.domain.ProductListViewModel
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
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ProductListViewModel::class.java)
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
        activity?.main_button_tab?.switchColorButton(true)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.fragmentManager = fragmentManager
        swipe_refresh_product.setOnRefreshListener(this)
        initToolbar()
        initRv()
        addGeneratedProduct(viewModel.productListVM)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.swich_view_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        if (adapter.isLinearListModeView) {
            adapter.isLinearListModeView = false
            item.setIcon(R.drawable.ic_menu_icon_linear_list)
            initRv()
            true
        } else {
            adapter.isLinearListModeView = true
            item.setIcon(R.drawable.ic_menu_icon_grid_list)
            initRv()
            false
        }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.main_button_tab?.switchColorButton(false)
    }

    override fun onRefresh() {
        swipe_refresh_product.isRefreshing = false
    }

    private fun initRv() {
        if (adapter.isLinearListModeView) {
            recycler_list_product.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        } else {
            recycler_list_product.layoutManager = GridLayoutManager(activity, 2)
        }
        adapter.onProductClick = { toast("id ${it.id}") }
        adapter.notifyDataSetChanged()
        recycler_list_product.adapter = adapter
    }

    private fun addGeneratedProduct(products: List<Product>) {
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