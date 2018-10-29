package com.lite.doordash.ui.binding

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "placeholder")
fun loadImage(imageView: ImageView, url: String, placeholder: Drawable) {
    Picasso.get().load(url).placeholder(placeholder).into(imageView)
}

