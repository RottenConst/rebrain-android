package com.rebrain.konstload.foodapp.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseActivity
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * главная активность приложения с которой начинаются основные действия в приложении
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pageAdapter = FragmentCarouselStateAdapter(supportFragmentManager)
        view_pager.adapter = pageAdapter
        text_view.text = this.localClassName
    }

    companion object {
        fun start(context: Context){
            startActivity(context, Intent(context, MainActivity::class.java), null)
        }
    }
}
