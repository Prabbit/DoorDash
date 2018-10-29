package com.lite.doordash.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lite.doordash.databinding.RestaurantRowBinding
import com.lite.doordash.model.homescreen.RestaurantModel

class RestaurantListAdapter(private val items: List<RestaurantModel>) :
    RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RestaurantRowBinding.inflate(
            LayoutInflater.from(parent?.context), parent, false
        )
    )

    override fun getItemCount() = items.size

    class ViewHolder(private val binding: RestaurantRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listData: RestaurantModel) {
            binding.model = listData
        }
    }
}