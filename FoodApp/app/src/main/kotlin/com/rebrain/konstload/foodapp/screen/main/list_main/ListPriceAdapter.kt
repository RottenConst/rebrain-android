package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselAdapter
import com.rebrain.konstload.foodapp.util.Generator
import kotlinx.android.synthetic.main.layout_item_view_pager.view.*
import kotlinx.android.synthetic.main.layout_list_item_product.view.*

/**
 * Адаптер для отображения списка продуктов
 */
class ListPriceAdapter(
    val products: MutableList<Product> = mutableListOf(),
    var isLinearListModeView: Boolean = true,
    var fragmentManager: FragmentManager? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutProductListItem = R.layout.layout_list_item_product
    private val layoutProductGridItem = R.layout.layout_grid_item_product
    private val layoutCarouselItem = R.layout.layout_item_view_pager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            CarouselHolder(LayoutInflater.from(parent.context), parent, layoutCarouselItem)
        } else {
            when (isLinearListModeView) {
                true -> ListPriceHolder(LayoutInflater.from(parent.context), parent, layoutProductListItem)
                else -> ListPriceHolder(LayoutInflater.from(parent.context), parent, layoutProductGridItem)
            }
        }
    }

    override fun getItemCount(): Int = products.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TypeListHolder.CAROUSEL_HOLDER.ordinal
            else -> TypeListHolder.PRODUCT_HOLDER.ordinal
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = products[position]
        when (holder) {
            is ListPriceHolder -> holder.bindProduct(product)
            is CarouselHolder -> holder.bindCarousel(fragmentManager, position)
        }
    }

    open class BaseListHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
        RecyclerView.ViewHolder(inflater.inflate(resource, parent, false))

    class ListPriceHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
        BaseListHolder(inflater, parent, resource) {
        fun bindProduct(data: Product) {
            itemView.text_for_product.text = data.name
            itemView.text_for_price.text = data.id.toString()
            Glide.with(itemView.context)
                .load(R.mipmap.img_product_one)
                .into(itemView.image_product)
        }
    }

    class CarouselHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
        BaseListHolder(inflater, parent, resource) {
        fun bindCarousel(fm: FragmentManager?, page: Int) {
            itemView.main_carousel_item.adapter = fm?.let { FragmentCarouselAdapter(it) }
            itemView.carousel_indicator.setupWithViewPager(itemView.main_carousel_item, true)
            CarouselFragment.newInstance(page, Generator.images)
        }
    }
}