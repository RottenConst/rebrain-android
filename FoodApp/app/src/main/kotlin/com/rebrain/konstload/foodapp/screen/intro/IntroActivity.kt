package com.rebrain.konstload.foodapp.screen.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseActivity
import com.rebrain.konstload.foodapp.screen.main.MainActivity
import com.rebrain.konstload.foodapp.util.HelpUserProgress.setProgressHelp
import com.rebrain.konstload.foodapp.util.ProgressHelp.INTRO
import kotlinx.android.synthetic.main.activity_intro.*

/**
 * Интро-экран с кратким описанием возможностей приложения, запускается 1 раз, при первом запуске приложения.
 **/
class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setProgressHelp(this, INTRO, false)
        info_screen.setOnClickListener {
            MainActivity.start(this)
            finishAffinity()
        }
    }

    companion object {
        fun start(context: Context) {
            startActivity(context, Intent(context, IntroActivity::class.java), null)
        }
    }
}