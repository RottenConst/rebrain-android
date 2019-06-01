package com.rebrain.konstload.foodapp.screen.main.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * класс фрагмент для реализации главного таба
 */
class MainTabFragment : BaseFragment() {

    override fun getName(): String {
        return "MainTabFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pageAdapter = FragmentCarouselAdapter(childFragmentManager)
        view_pager.adapter = pageAdapter
    }

    companion object {
        fun newInstance(): MainTabFragment {
            return MainTabFragment()
        }
    }
}