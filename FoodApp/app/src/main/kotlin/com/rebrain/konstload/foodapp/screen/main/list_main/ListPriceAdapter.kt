package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.domain.Product
import com.rebrain.konstload.foodapp.iteractor.ProductModeView
import com.rebrain.konstload.foodapp.screen.main.carousel.CarouselFragment
import com.rebrain.konstload.foodapp.screen.main.carousel.adapter.FragmentCarouselStateAdapter
import com.rebrain.konstload.foodapp.util.Generator
import kotlinx.android.synthetic.main.layout_item_view_pager.view.*
import kotlinx.android.synthetic.main.layout_list_item_product.view.*

/**
 * Адаптер для отображения списка продуктов
 */
class ListPriceAdapter(
    val products: MutableList<Product> = mutableListOf(),
    internal var PriceModeView: ProductModeView = ProductModeView.LINEAR_MODE_VIEW_PRODUCT,
    var fragmentManager: FragmentManager? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var onProductClick: ((Product) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = when {
            viewType == 0 -> R.layout.layout_item_view_pager
            PriceModeView == ProductModeView.LINEAR_MODE_VIEW_PRODUCT -> R.layout.layout_list_item_product
            else -> R.layout.layout_grid_item_product
        }
        return if (viewType == 0) {
            CarouselHolder(LayoutInflater.from(parent.context), parent, layout)
        } else {
            ListPriceHolder(LayoutInflater.from(parent.context), parent, layout)
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
        when (holder) {
            is ListPriceHolder -> {
                val product = products[position - 1]
                holder.bindProduct(product)
            }
            is CarouselHolder -> holder.bindCarousel(fragmentManager, position)
        }
    }

    open class BaseListHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
        RecyclerView.ViewHolder(inflater.inflate(resource, parent, false))

    inner class ListPriceHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
        BaseListHolder(inflater, parent, resource) {
        init {
            itemView.image_basked.setOnClickListener { onProductClick.invoke(products[adapterPosition - 1]) }
        }

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
            itemView.main_carousel_item.adapter = fm?.let { FragmentCarouselStateAdapter(it) }
            itemView.carousel_indicator.setupWithViewPager(itemView.main_carousel_item, true)
            CarouselFragment.newInstance(page, Generator.images)
        }
    }
}