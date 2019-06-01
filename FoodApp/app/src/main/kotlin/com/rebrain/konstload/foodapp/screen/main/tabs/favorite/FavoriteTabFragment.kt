package com.rebrain.konstload.foodapp.screen.main.tabs.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorited.*

/**
 * класс фрагмент для реализации таба с избранным
 */
class FavoriteTabFragment : BaseFragment() {

    override fun getName(): String {
        return "FavoriteTabFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_favorited, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        text_view.text = getName()
    }

    companion object {
        fun newInstance() = FavoriteTabFragment()
    }
}