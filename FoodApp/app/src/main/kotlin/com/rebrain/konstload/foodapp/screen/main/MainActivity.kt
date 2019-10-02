package com.rebrain.konstload.foodapp.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseActivity
import com.rebrain.konstload.foodapp.view.TabType
import kotlinx.android.synthetic.main.activity_main.*

/**
 * главная активность приложения с которой начинаются основные действия в приложении
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFirstFragment()

        TabType.MAIN.event = { moveFragment(TabType.MAIN) }
        TabType.FAVORITE.event = { moveFragment(TabType.FAVORITE) }

        bottom_bar.setClickListener(TabType.FAVORITE)
        bottom_bar.setClickListener(TabType.MAIN)
    }

    private fun addFirstFragment() {
        if (supportFragmentManager.fragments.isEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, TabType.MAIN.fragment)
                .add(R.id.fragment_container, TabType.FAVORITE.fragment)
                .commit()
            replaceFragment(TabType.MAIN.fragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }

    private fun moveFragment(type: TabType) {
        when (type) {
            TabType.MAIN -> replaceFragment(type.fragment)
            TabType.FAVORITE -> replaceFragment(type.fragment)
        }
    }

    companion object {
        fun start(context: Context) {
            startActivity(context, Intent(context, MainActivity::class.java), null)
        }
    }
}
