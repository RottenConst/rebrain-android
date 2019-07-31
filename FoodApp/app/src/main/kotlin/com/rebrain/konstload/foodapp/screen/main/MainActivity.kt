package com.rebrain.konstload.foodapp.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseActivity
import com.rebrain.konstload.foodapp.screen.main.tabs.favorite.FavoriteTabFragment
import com.rebrain.konstload.foodapp.screen.main.tabs.main.MainTabFragment
import com.rebrain.konstload.foodapp.view.BottomBar
import com.rebrain.konstload.foodapp.view.TabType
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_bar.*
import timber.log.Timber

/**
 * главная активность приложения с которой начинаются основные действия в приложении
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment(MainTabFragment.newInstance())
        bottom_bar.checkButton(main_button_tab)

        TabType.MAIN.event = { createFragment(it.fragment) }
        TabType.FAVORITE.event = { createFragment(it.fragment) }

        bottom_bar.setClickListener(TabType.FAVORITE)
        bottom_bar.setClickListener(TabType.MAIN)
    }

    private fun createFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit()
    }

    companion object {
        fun start(context: Context) {
            startActivity(context, Intent(context, MainActivity::class.java), null)
        }
    }
}
