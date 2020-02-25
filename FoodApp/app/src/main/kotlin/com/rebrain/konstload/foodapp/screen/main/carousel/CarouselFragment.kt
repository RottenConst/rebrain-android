package com.rebrain.konstload.foodapp.screen.main.carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_carousel.*

const val ARGUMENT_PAGE_NUMBER = "arg_page_number"

/**
 * класс фрагмент для реализации карусели с картинками
 */
class CarouselFragment : BaseFragment() {

    private var pageNumber = 0

    override fun getName(): String {
        return "CarouselFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments?.getInt(ARGUMENT_PAGE_NUMBER) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_carousel, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view.context).load(images[pageNumber]).into(image_food)
    }

    companion object {
        private val images = mutableListOf<Int>()

        fun newInstance(page: Int, images: List<Int>): CarouselFragment {
            val carouselFragment = CarouselFragment()
            this.images.clear()
            this.images.addAll(images)
            val arg = bundleOf(ARGUMENT_PAGE_NUMBER to page)
            carouselFragment.arguments = arg
            return carouselFragment
        }
    }
}