package com.rebrain.konstload.foodapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.rebrain.konstload.foodapp.R
import kotlinx.android.synthetic.main.layout_bottom_bar.view.*

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
        addView(ButtonTabBar(context, icon = icon, text = text))
    }

    fun checkButton(item: View) {
        buttons.forEach { button ->
            if (button.id == item.id) {
                button.switchColorButton(true)
            } else {
                button.switchColorButton(false)
            }
        }
    }

    fun setClickListener(type: TabType) {
        when (type.ordinal) {
            buttons.indexOf(main_button_tab) -> buttons[type.ordinal].setOnClickListener {
                type.event.invoke(type)
                checkButton(it)
            }
            buttons.indexOf(favorite_button_tab) -> buttons[type.ordinal].setOnClickListener {
                type.event.invoke(type)
                checkButton(it)
            }
        }
    }

    companion object {
        var buttons = mutableListOf<ButtonTabBar>()
    }
}


