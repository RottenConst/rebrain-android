package com.rebrain.konstload.foodapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.rebrain.konstload.foodapp.R

class BottomTab(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.bottom_tab, this)

        val imageMain: ImageView = findViewById(R.id.image_main)
        val caption: TextView = findViewById(R.id.caption)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BottomTab)
        imageMain.setImageDrawable(attributes.getDrawable(R.styleable.BottomTab_icon_tabs))
        caption.text = attributes.getString(R.styleable.BottomTab_caption_text)
        attributes.recycle()
    }

}