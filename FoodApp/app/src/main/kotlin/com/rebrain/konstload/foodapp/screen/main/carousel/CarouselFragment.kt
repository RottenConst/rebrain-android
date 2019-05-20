package com.rebrain.konstload.foodapp.screen.main.carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_carousel.*

const val ARGUMENT_PAGE_NUMBER = "arg_page_number"
/**
 * класс фрагмент для резации карусели с картинками
 */
class CarouselFragment : BaseFragment() {

    override fun getName(): String {
        return "CarouselFragment"
    }

    private var pageNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments?.getInt(ARGUMENT_PAGE_NUMBER) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_carousel, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_food.setImageResource(images[pageNumber])
    }

    companion object {
        val images = listOf(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten
        )

        fun newInstance(page: Int): CarouselFragment {
            val carouselFragment = CarouselFragment()
            val arg = Bundle()
            arg.putInt(ARGUMENT_PAGE_NUMBER, page)
            carouselFragment.arguments = arg
            return carouselFragment
        }
    }
}