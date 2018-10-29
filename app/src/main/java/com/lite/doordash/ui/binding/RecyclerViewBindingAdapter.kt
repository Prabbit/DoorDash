package com.lite.doordash.ui.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter

@BindingAdapter("app:adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: Adapter<RecyclerView.ViewHolder>) {
    adapter.let {
        recyclerView.adapter = adapter }
}