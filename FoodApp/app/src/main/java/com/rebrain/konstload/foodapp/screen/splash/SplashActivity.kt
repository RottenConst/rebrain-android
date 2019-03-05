package com.rebrain.konstload.foodapp.screen.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rebrain.konstload.foodapp.MainActivity
import com.rebrain.konstload.foodapp.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            delay(500)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
            }
        }


}
