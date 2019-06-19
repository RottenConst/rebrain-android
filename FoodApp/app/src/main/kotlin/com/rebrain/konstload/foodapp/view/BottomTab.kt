package com.rebrain.konstload.foodapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.rebrain.konstload.foodapp.R
import kotlinx.android.synthetic.main.bottom_tab.view.*

class BottomTab @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private var text: String = ""
    private var icon: Int = 0

    init {
        View.inflate(context, R.layout.bottom_tab, this)
        attrs?.let { applyAttrs(it) }
        orientation = VERTICAL
    }


    @SuppressLint("MissingSuperCall")
    override fun onFinishInflate() {
        icon_main.setImageResource(icon)
        caption_tab.text = text
    }


    @SuppressLint("Recycle")
    private fun applyAttrs(attrs: AttributeSet) {
        context.obtainStyledAttributes(attrs, R.styleable.BottomTab, 0, 0).apply {
            try {
                icon = getResourceId(R.styleable.BottomTab_icon_tabs, 0)
                text = getText(R.styleable.BottomTab_caption_text) as String
            } finally {
                recycle()
            }
        }
    }

    fun setOnClickTab(listener: OnClickListener) {
        setOnClickListener(listener)
    }
}