package com.rebrain.konstload.foodapp.view

import androidx.fragment.app.Fragment
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.screen.main.tabs.favorite.FavoriteTabFragment
import com.rebrain.konstload.foodapp.screen.main.tabs.main.MainTabFragment

enum class TabType(val fragment: Fragment) {
    MAIN(MainTabFragment.newInstance()),
    FAVORITE(FavoriteTabFragment.newInstance());

    var event: () -> Unit = {}
}