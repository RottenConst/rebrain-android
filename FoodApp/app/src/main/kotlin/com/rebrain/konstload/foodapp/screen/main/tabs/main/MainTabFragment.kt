package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import com.rebrain.konstload.foodapp.screen.main.list_main.ListPriceAdapter
import com.rebrain.konstload.foodapp.util.Generator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * класс фрагмент для реализации главного таба
 */
class MainTabFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private val adapter = ListPriceAdapter()

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
        val pageAdapter = FragmentCarouselAdapter(childFragmentManager)
        fragment_main_view_pager.adapter = pageAdapter
        swipe_refresh_product.setOnRefreshListener(this)
        initToolbar()
        initRv()
        addGeneratedProduct()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.swich_view_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        if (adapter.isLinearListModeView) {
            adapter.isLinearListModeView = false
            item?.setIcon(R.drawable.ic_menu_icon_linear_list)
            initRv()
            true
        } else {
            adapter.isLinearListModeView = true
            item?.setIcon(R.drawable.ic_menu_icon_grid_list)
            initRv()
            false
        }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.products.clear()
        activity?.main_button_tab?.switchColorButton(false)
    }

    override fun onRefresh() {
        adapter.products.clear()
        addGeneratedProduct()
        swipe_refresh_product.isRefreshing = false
    }

    private fun initRv() {
        if (adapter.isLinearListModeView) {
            recycler_list_product.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter.notifyDataSetChanged()
        } else {
            recycler_list_product.layoutManager = GridLayoutManager(activity, 2)
            adapter.notifyDataSetChanged()
        }
        recycler_list_product.adapter = adapter
    }

    private fun addGeneratedProduct() {
        adapter.products.addAll(Generator.getProducts())
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