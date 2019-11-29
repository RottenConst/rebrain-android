package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import com.rebrain.konstload.foodapp.screen.main.list_main.TypeListHolder.CAROUSEL_VIEW_PAGER
import com.rebrain.konstload.foodapp.screen.main.list_main.TypeListHolder.PRODUCTS
import kotlinx.android.synthetic.main.layout_carousel_item.view.*
import kotlinx.android.synthetic.main.layout_list_item_product.view.*

/**
 * Адаптер для отображения списка продуктов
 */
class ListPriceAdapter(
    val products: MutableList<Product> = mutableListOf(),
    var isLinearListModeView: Boolean = true,
    var fm: FragmentManager? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when {
            viewType >= 1 -> {
                when {
                    isLinearListModeView -> ListPriceHolder(
                        LayoutInflater.from(parent.context).inflate(
                            R.layout.layout_list_item_product,
                            parent,
                            false
                        )
                    )
                    else -> ListPriceHolder(
                        LayoutInflater.from(parent.context).inflate(
                            R.layout.layout_grid_item_product,
                            parent,
                            false
                        )
                    )
                }
            }
            else -> {
                CarouselImageHolder(LayoutInflater.from(parent.context), parent)
            }
        }
    }

    override fun getItemCount(): Int = products.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            CAROUSEL_VIEW_PAGER.ordinal
        } else PRODUCTS.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = products[position]
        when (holder) {
            is CarouselImageHolder -> fm?.let { holder.bindCarousel(it, position) }
            is ListPriceHolder -> holder.bind(product)
        }
    }

    open class BaseHolder(view: View) : RecyclerView.ViewHolder(view)

    class ListPriceHolder(view: View) : BaseHolder(view) {
        fun bind(data: Product) {
            itemView.text_for_product.text = data.name
            itemView.text_for_price.text = data.id.toString()
            Glide.with(itemView.context)
                .load(R.mipmap.img_product_one)
                .into(itemView.image_product)
        }
    }

    class CarouselImageHolder(inflater: LayoutInflater, parent: ViewGroup) : BaseHolder(
        inflater.inflate(R.layout.layout_carousel_item, parent, false)
    ) {
        fun bindCarousel(fm: FragmentManager, page: Int) {
            val adapter = FragmentCarouselAdapter(fm)
            itemView.main_view_pager_image.adapter = adapter
            itemView.carousel_indicator.setupWithViewPager(itemView.main_view_pager_image, true)
            CarouselFragment.newInstance(page)
        }
    }
}