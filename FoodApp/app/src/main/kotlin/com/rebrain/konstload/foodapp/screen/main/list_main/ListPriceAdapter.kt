package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rebrain.konstload.foodapp.R
import com.rebrain.konstload.foodapp.domain.Product
import kotlinx.android.synthetic.main.layout_list_item_product.view.*

/**
 * Адаптер для отображения списка продуктов
 */
class ListPriceAdapter(
    val products: MutableList<Product> = mutableListOf(),
    var modeHolderView: Boolean = true
) :
    RecyclerView.Adapter<ListPriceAdapter.ListPriceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPriceHolder {
        return ListPriceHolder(LayoutInflater.from(parent.context), parent, modeHolderView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ListPriceHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    class ListPriceHolder(inflater: LayoutInflater, parent: ViewGroup, modeHolder: Boolean) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                when (modeHolder) {
                    true -> R.layout.layout_list_item_product
                    else -> R.layout.layout_grid_item_product
                }, parent, false)
        )
    {
        fun bind(data: Product) {
            itemView.text_for_product.text = data.name
            itemView.text_for_price.text = data.id.toString()
            Glide.with(itemView.context)
                .load(R.mipmap.img_product_one)
                .into(itemView.image_product)
        }
    }
}