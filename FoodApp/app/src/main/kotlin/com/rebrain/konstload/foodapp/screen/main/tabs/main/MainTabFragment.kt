package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
class MainTabFragment : BaseFragment() {

    private val adapter = ListPriceAdapter()

    override fun getName(): String {
        return "MainTabFragment"
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
        initToolbar()
        initRv()
        adapter.products.addAll(Generator.getProducts())
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.products.clear()
        activity?.main_button_tab?.switchColorButton(false)
    }

    private fun initRv() {
        recycler_list_product.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler_list_product.adapter = adapter
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