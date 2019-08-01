package com.rebrain.konstload.foodapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import com.rebrain.konstload.foodapp.R
import kotlinx.android.synthetic.main.layout_button_tab_bar.view.*

/**
 * Кнопка боттом-бара
 **/
class ButtonTab @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    private var icon: Int = 0,
    private var text: String = ""
) :
    LinearLayout(context, attrs) {

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

    fun switchColorButton(click: Boolean) {
        if (click) {
            setColorButton(R.color.activeButtonColor)
        } else {
            setColorButton(R.color.black)
        }
    }

    private fun setColorButton(color: Int) {
        title_button_tab.setTextColor(resources.getColor(color))
        icon_button_tab.setColorFilter(resources.getColor(color))
    }

    private fun setText(text: String){
        title_button_tab.text = text
    }

    private fun setIcon(color: Int) {
        icon_button_tab.setImageResource(color)
    }

    private fun applyAttrs(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ButtonTab, 0, 0).apply {
            try {
                text = getText(R.styleable.ButtonTab_title_button_tab).toString()
                icon = getResourceId(R.styleable.ButtonTab_icon_button_tab, 0)
                when(getInt(R.styleable.ButtonTab_type_btn, 0)){
                    0 -> TabType.MAIN
                    1 -> TabType.FAVORITE
                }
            } finally {
                recycle()
            }
        }
    }

}