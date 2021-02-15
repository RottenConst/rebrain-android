package com.rebrain.konstload.foodapp.screen.main.list_main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseListHolder(inflater: LayoutInflater, parent: ViewGroup, resource: Int) :
    RecyclerView.ViewHolder(inflater.inflate(resource, parent, false))