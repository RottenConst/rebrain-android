package com.rebrain.konstload.foodapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.rebrain.konstload.foodapp.R
import kotlinx.android.synthetic.main.layout_button_tab_bar.view.*

/**
 * Кнопка боттом-бара
 **/
class ButtonTabBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    private var icon: Int = 0,
    private var text: String = ""
) :
    LinearLayout(context, attrs) {

    private lateinit var listener: OnClickListener

    init {
        View.inflate(context, R.layout.layout_button_tab_bar, this)
        attrs?.let { applyAttrs(it) }
        orientation = VERTICAL
        BottomBar.buttons.add(this)
    }

    @SuppressLint("MissingSuperCall")
    override fun onFinishInflate() {
        icon_button_tab.setImageResource(icon)
        title_button_tab.text = text
    }

    fun setButtonListener(listener: OnClickListener) {
        this.listener = listener
        listener.onClick(this)
    }

    fun switchIconButton(click: Boolean, check: Int) {
        if (click) {
            setIcon(check)
        } else {
            setIcon(icon)
        }
    }

    fun setColorButton(color: Int) {
        title_button_tab.setTextColor(color)
        icon_button_tab.setColorFilter(color)
    }

    private fun setText(text: String){
        title_button_tab.text = text
    }

    private fun setIcon(color: Int) {
        icon_button_tab.setImageResource(color)
    }

    private fun applyAttrs(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ButtonTabBar, 0, 0).apply {
            try {
                text = getText(R.styleable.ButtonTabBar_title_button_tab).toString()
                icon = getResourceId(R.styleable.ButtonTabBar_icon_button_tab, 0)
            } finally {
                recycle()
            }
        }
    }

}