package com.rebrain.konstload.foodapp.screen.intro

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rebrain.konstload.foodapp.R
/**
  * Интро-экран с кратким описанием возможностей приложения, запускается 1 раз, при первом запуске приложения.
  **/
class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        applicationContext.getSharedPreferences(R.string.first_run.toString(), Context.MODE_PRIVATE)
            .edit()
            .putBoolean(R.string.first_run.toString(), false)
            .apply()
    }
}
