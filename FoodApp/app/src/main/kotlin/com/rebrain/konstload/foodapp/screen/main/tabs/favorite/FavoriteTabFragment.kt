package com.rebrain.konstload.foodapp.screen.main.tabs.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.App
import com.rebrain.konstload.foodapp.base.BaseFragment
import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.screen.main.list_main.ListPriceAdapter
import kotlinx.android.synthetic.main.fragment_favorited.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * класс фрагмент для реализации таба с избранным
 */
class FavoriteTabFragment : BaseFragment() {

    private val screenComponent = App().buildScreenComponent()
    private val adapter = ListPriceAdapter()

    override fun getName(): String {
        return "FavoriteTabFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.favorite_button_tab?.switchColorButton(true)
        return inflater.inflate(R.layout.fragment_favorited, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.fragmentManager = fragmentManager
        initToolbar()
        initRv()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.favorite_button_tab?.switchColorButton(false)
    }

    private fun initToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(food_toolbar)
        activity.supportActionBar?.setTitle(R.string.toolbar_text_favorite)
    }

    private fun initRv(){
        when (adapter.priceModeView) {
            ProductModeView.LINEAR_MODE_VIEW_PRODUCT -> recycler_list_product.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            ProductModeView.GRID_MODE_VIEW_PRODUCT -> recycler_list_product.layoutManager =
                GridLayoutManager(activity, 2)
        }
    }

    companion object {
        fun newInstance() = FavoriteTabFragment()
    }
}