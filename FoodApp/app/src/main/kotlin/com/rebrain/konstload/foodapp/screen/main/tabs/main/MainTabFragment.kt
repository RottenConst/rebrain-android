package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * класс фрагмент для реализации главного таба
 */
class MainTabFragment : BaseFragment() {

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.main_button_tab?.switchColorButton(false)
    }

    private fun initToolbar() {
        food_toolbar.title = resources.getText(R.string.toolbar_text_main)
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(food_toolbar)
    }

    companion object {
        fun newInstance(): MainTabFragment {
            return MainTabFragment()
        }
    }
}