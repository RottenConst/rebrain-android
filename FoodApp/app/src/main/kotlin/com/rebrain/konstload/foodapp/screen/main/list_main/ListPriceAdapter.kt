package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
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
    val context: FragmentActivity?
) :
    RecyclerView.Adapter<ListPriceAdapter.ListPriceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPriceHolder {
        return ListPriceHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ListPriceHolder, position: Int) {
        val product = products[position]
        holder.bind(product, this.context)
    }

    class ListPriceHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.layout_list_item_product, parent, false)
    ) {
        fun bind(data: Product, context: FragmentActivity?) {
            itemView.text_for_product.text = data.name
            itemView.text_for_price.text = data.id.toString()
            if (context != null) {
                Glide.with(context)
                    .load(R.mipmap.img_product_one)
                    .into(itemView.image_product)
            }
        }
    }
}