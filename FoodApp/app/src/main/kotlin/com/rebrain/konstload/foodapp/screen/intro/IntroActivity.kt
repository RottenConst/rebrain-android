package com.rebrain.konstload.foodapp.screen.intro

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.utils.runNotActivity

/**
 * Интро-экран с кратким описанием возможностей приложения, запускается 1 раз, при первом запуске приложения.
 **/
class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        runNotActivity(this)
    }
}
