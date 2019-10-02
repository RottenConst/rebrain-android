package com.rebrain.konstload.foodapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.rebrain.konstload.foodapp.R

/**
 * Боттом-бар
 **/
class BottomBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.layout_bottom_bar, this)
        orientation = HORIZONTAL
        attrs?.let { applyAttrs(it) }
    }

    private fun applyAttrs(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.BottomBar, 0, 0).apply {
            try {
                setBackgroundColor(getColor(R.styleable.BottomBar_background_color, 0))
            } finally {
                recycle()
            }
        }
    }

    fun createButtonTab(icon: Int, text: String) {
        addView(ButtonTab(context, icon = icon, text = text))
    }

    fun setClickListener(type: TabType) {
        if (type.ordinal == buttons.indexOf(buttons[type.ordinal])) {
            buttons[type.ordinal]?.setOnClickListener {
                type.event()
            }
        }
    }

    companion object {
        val buttons = arrayOfNulls<ButtonTab>(2)
    }
}

